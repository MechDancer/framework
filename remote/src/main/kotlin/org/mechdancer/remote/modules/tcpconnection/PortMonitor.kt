package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Addresses
import org.mechdancer.remote.resources.UdpCmd

/**
 * 地址同步机制 1
 * 这个模块用于 TCP 连接的发起者
 * 依赖地址资源和组播收发功能
 * 将发起地址询问并更新地址资源
 */
class PortMonitor : UniqueComponent<PortMonitor>(PortMonitor::class),
                    Dependent,
                    MulticastListener {
    private val manager = DependencyManager()

    private val broadcast by manager.mustUnique { it: MulticastBroadcaster -> it::broadcast }
    private val addresses by manager.must<Addresses>()

    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    override val interest = INTEREST

    /** 向所有远端发送端口询问 */
    fun askEveryone() = broadcast(UdpCmd.ADDRESS_ASK, byteArrayOf())

    /** 向一个名为 [name] 的远端发送端口询问 */
    fun ask(name: String) = broadcast(UdpCmd.ADDRESS_ASK, name.toByteArray())

    override fun process(remotePacket: RemotePacket) {
        val (sender, _, payload) = remotePacket

        if (sender.isNotBlank()) { // 忽略匿名终端的地址
            addresses[sender] = payload(0) shl 8 or payload(1)
            logger?.info("received port from $sender")
        }
    }

    private companion object {
        val INTEREST = setOf(UdpCmd.ADDRESS_ACK)
        operator fun ByteArray.invoke(n: Int) = get(n).toInt() and 0xff
    }
}
