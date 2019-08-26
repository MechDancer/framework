package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Name
import org.mechdancer.remote.resources.ServerSockets
import org.mechdancer.remote.resources.UdpCmd

/**
 * 端口同步机制 2
 * 这个模块用于 TCP 连接的接收者
 * 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发
 */
class PortBroadcaster : UniqueComponent<PortBroadcaster>(),
                        Dependent,
                        MulticastListener {

    private val manager = DependencyManager()

    private val name by manager.mustUnique { x: Name -> x.field }
    private val broadcast by manager.mustUnique { x: MulticastBroadcaster -> x::broadcast }
    private val port by manager.mustUnique { x: ServerSockets -> x.default.localPort }

    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    override val interest = INTEREST

    override fun process(remotePacket: RemotePacket) {
        if (remotePacket.payload.isEmpty() || String(remotePacket.payload) == name) {
            broadcast(UdpCmd.ADDRESS_ACK, byteArrayOf((port shr 8).toByte(), port.toByte()))
            logger?.debug("reply port asking from ${remotePacket.sender}")
        }
    }

    private companion object {
        val INTEREST = setOf(UdpCmd.ADDRESS_ASK)
    }
}
