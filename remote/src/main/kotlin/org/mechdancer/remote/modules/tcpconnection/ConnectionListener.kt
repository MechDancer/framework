package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component
import org.mechdancer.remote.resources.Command
import java.net.Socket

/**
 * 短连接监听者
 */
interface ConnectionListener : Component {
    val interest: Command
    fun process(client: String, socket: Socket): Boolean
}
