package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.UdpCmd

/**
 * 通用组播协议，支持接收通用组播 [UdpCmd.COMMON] = 127
 * 收到将调用 [received]
 */
class CommonUdpServer(
    private val received: (String, ByteArray) -> Unit
) : UniqueComponent<CommonUdpServer>(), MulticastListener {

    override val interest = INTEREST

    override fun process(remotePacket: RemotePacket) =
        received(remotePacket.sender, remotePacket.payload)

    private companion object {
        val INTEREST = setOf(UdpCmd.COMMON.id)
    }
}
