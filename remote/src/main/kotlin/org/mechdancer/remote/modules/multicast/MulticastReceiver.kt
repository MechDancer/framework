package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.group.Rule
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.protocol.SimpleInputStream
import org.mechdancer.remote.protocol.readEnd
import org.mechdancer.remote.resources.*
import java.net.DatagramPacket
import java.net.Inet4Address
import java.net.InterfaceAddress
import kotlin.concurrent.getOrSet

/**
 * 组播小包接收
 * @param bufferSize 缓冲区容量
 */
class MulticastReceiver(
    private val bufferSize: Int = 65536,
    private val rule: Rule = Rule()
) : UniqueComponent<MulticastReceiver>(), Dependent {
    private val manager = DependencyManager()

    // 线程独立缓冲
    private val buffer = ThreadLocal<DatagramPacket>()
    // 过滤环路数据
    private val name by manager.maybe("") { it: Name -> it.field }
    // 接收套接字
    private val sockets by manager.must<MulticastSockets>()
    // 处理回调
    private val listeners = mutableSetOf<MulticastListener>()

    // 网络管理
    private val networks by manager.maybe(null) { it: Networks -> it.view }
    // 地址管理
    private val addresses by manager.maybe<Addresses>()

    override fun sync(dependency: org.mechdancer.dependency.Component): Boolean {
        manager.sync(dependency)
        if (dependency is MulticastListener) listeners.add(dependency)
        return false
    }

    operator fun invoke(): RemotePacket? {
        val packet = buffer
            .getOrSet { DatagramPacket(ByteArray(bufferSize), bufferSize) }
            .apply(sockets.default::receive)

        val stream = SimpleInputStream(core = packet.data, end = packet.length)
        val sender = stream.readEnd()

        if (sender == name || rule decline sender) return null

        val address = packet.address as Inet4Address

        networks
            ?.toList()
            ?.find { (_, it) -> it match address }
            ?.let { (network, _) -> sockets[network] }

        addresses?.set(sender, address)

        return RemotePacket(
            sender = sender,
            command = stream.read().toByte(),
            payload = stream.lookRest()
        ).also { pack ->
            listeners
                .filter {
                    it.interest.isEmpty()
                        || pack.command in it.interest.map(Command::id)
                }
                .forEach { it process pack }
        }
    }

    private companion object {
        fun Inet4Address.toInt() = address
            .fold(0) { acc, byte -> (acc shl 8) or (byte.toInt() and 0xff) }

        infix fun InterfaceAddress.match(other: Inet4Address): Boolean {
            if (address == other) return true
            val mask = Int.MAX_VALUE shl 32 - networkPrefixLength.toInt()
            return other.toInt() and mask == (address as Inet4Address).toInt() and mask
        }
    }
}
