package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.dependency.unique.UniqueDependencyManager
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

    private val manager = UniqueDependencyManager()

    private val name by manager.must { it: Name -> it.field }
    private val broadcast by manager.must { it: MulticastBroadcaster -> it::broadcast }
    private val port by manager.must { it: ServerSockets -> it.default.localPort }

    override fun sync(dependency: Component) = manager.sync(dependency)

    override val interest = INTEREST

    override fun process(remotePacket: RemotePacket) {
        if (remotePacket.payload.isEmpty() || String(remotePacket.payload) == name)
            broadcast(UdpCmd.ADDRESS_ACK, byteArrayOf((port shr 8).toByte(), port.toByte()))
    }

    private companion object {
        val INTEREST = setOf(UdpCmd.ADDRESS_ASK.id)
    }
}
