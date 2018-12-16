package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.Component
import org.mechdancer.remote.protocol.RemotePacket

/**
 * 组播监听者
 */
interface MulticastListener : Component {
    val interest: Collection<Byte>
    infix fun process(remotePacket: RemotePacket)
}
