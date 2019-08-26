package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.group.GroupMonitor
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
    private val name by manager.maybe("") { x: Name -> x.field }
    // 接收套接字
    private val sockets by manager.must<MulticastSockets>()
    // 组成员管理
    private val groupMonitor by manager.maybe<GroupMonitor>()
    // 处理回调
    private val listeners = mutableSetOf<MulticastListener>()

    // 网络管理
    private val networks by manager.maybe(null) { x: Networks -> x.view }
    // 地址管理
    private val addresses by manager.maybe<Addresses>()

    // 日志器
    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component): Boolean {
        manager.sync(dependency)
        if (dependency is MulticastListener) listeners.add(dependency)
        return false
    }

    operator fun invoke(): RemotePacket? {
        logger?.debug("waiting for multicast packet...")
        val packet = buffer
            .getOrSet { DatagramPacket(ByteArray(bufferSize), bufferSize) }
            .apply(sockets.default::receive)

        val stream = SimpleInputStream(core = packet.data, end = packet.length)
        val sender = stream.readEnd()

        if (sender == name || rule decline sender) return null

        val command = stream.read().toByte()
        val address = packet.address as Inet4Address
        // 更新组成员信息
        groupMonitor?.detect(sender, name.isNotBlank() && command == UdpCmd.YELL_ASK.id)
        // 更新地址认识
        addresses?.set(sender, address)
        // 打开对应网络
        networks
            ?.toList()
            ?.find { (_, it) -> it match address }
            ?.let { (network, _) -> sockets[network] }

        return RemotePacket(sender, command, stream.lookRest())
            .also { logger?.debug("received $it on $address") }
            .also { pack ->
                listeners
                    .asSequence()
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
