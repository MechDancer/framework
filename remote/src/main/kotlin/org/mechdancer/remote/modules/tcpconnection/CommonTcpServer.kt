package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket

/**
 * 通用 TCP 服务器
 */
class CommonTcpServer(private val block: (String, Socket) -> Any?) :
    UniqueComponent<CommonTcpServer>(CommonTcpServer::class),
    ShortConnectionListener {

    override val interest = TcpCmd.COMMON.id

    override fun process(client: String, socket: Socket) {
        block(client, socket)
    }
}
