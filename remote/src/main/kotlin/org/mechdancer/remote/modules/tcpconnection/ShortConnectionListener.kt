package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component
import java.net.Socket

/**
 * 短连接监听者
 */
interface ShortConnectionListener : Component {
    val interest: Byte
    fun process(client: String, socket: Socket)
}
