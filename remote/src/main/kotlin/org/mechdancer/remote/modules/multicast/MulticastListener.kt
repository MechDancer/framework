package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.Component
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Command

/**
 * 组播监听者
 */
interface MulticastListener : Component {
    val interest: Set<Command>
    infix fun process(remotePacket: RemotePacket)
}
