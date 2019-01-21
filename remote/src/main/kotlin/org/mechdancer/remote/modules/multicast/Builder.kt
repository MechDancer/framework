package org.mechdancer.remote.modules.multicast

import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.UdpCmd

/** 构造组播监听者 */
fun multicastListener(
    vararg interest: Command = arrayOf(UdpCmd.COMMON),
    block: (sender: String, cmd: Byte, payload: ByteArray) -> Unit
) = object : MulticastListener {
    override val interest = interest.toSet()

    override fun process(remotePacket: RemotePacket) {
        val (sender, cmd, payload) = remotePacket
        block(sender, cmd, payload)
    }

    override fun equals(other: Any?) = false
    override fun hashCode() = interest.hashCode()
}
