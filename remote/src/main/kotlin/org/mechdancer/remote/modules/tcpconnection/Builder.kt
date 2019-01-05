package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket

/** 构造 TCP 连接监听者 */
fun connectionListener(
    interest: Command = TcpCmd.COMMON,
    block: (client: String, socket: Socket) -> Boolean
) = object : ConnectionListener {
    override val interest = interest
    override fun process(client: String, socket: Socket) = block(client, socket)
    override fun equals(other: Any?) = false
    override fun hashCode() = interest.id.toInt()
}

/** 构造 TCP 对话监听者 */
fun dialogListener(
    block: (client: String, payload: ByteArray) -> ByteArray
) = object : ConnectionListener {
    override val interest = TcpCmd.Dialog

    override fun process(client: String, socket: Socket): Boolean {
        socket.say(block(client, socket.listen()))
        return true
    }

    override fun equals(other: Any?) =
        (other as? ConnectionListener)?.interest?.id == interest.id

    override fun hashCode() = interest.id.toInt()
}

/** 构造 TCP 消息监听者 */
fun mailListener(
    block: (client: String, payload: ByteArray) -> Unit
) = object : MailListener {
    override fun process(sender: String, payload: ByteArray) = block(sender, payload)
    override fun equals(other: Any?) = false
    override fun hashCode() = TcpCmd.Mail.id.toInt()
}
