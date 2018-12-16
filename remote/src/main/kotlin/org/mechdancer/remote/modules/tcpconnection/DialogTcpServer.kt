package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket

/**
 * TCP 应答服务器
 */
class DialogTcpServer(private val block: (String, ByteArray) -> ByteArray) :
    UniqueComponent<DialogTcpServer>(),
    ShortConnectionListener {

    override val interest = TcpCmd.Dialog.id

    override fun process(client: String, socket: Socket) =
        with(socket) { say(block(client, listen())) }
}
