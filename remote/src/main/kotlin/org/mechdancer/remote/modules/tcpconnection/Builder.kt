package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket

/** 构造 TCP 连接监听者 */
fun connectionListener(
    interest: Byte = TcpCmd.COMMON.id,
    block: (client: String, socket: Socket) -> Unit
) = object : ShortConnectionListener {
    override val interest = interest
    override fun process(client: String, socket: Socket) = block(client, socket)
    override fun equals(other: Any?) = false
    override fun hashCode() = interest.toInt()
}

/** 构造 TCP 对话监听者 */
fun dialogListener(
    block: (client: String, payload: ByteArray) -> ByteArray
) = connectionListener(TcpCmd.Dialog.id) { client, server ->
    server.say(block(client, server.listen()))
}

/** 构造 TCP 消息监听者 */
fun mailListener(
    block: (client: String, payload: ByteArray) -> Unit
) = object : MailListener {
    override fun process(sender: String, payload: ByteArray) = block(sender, payload)
    override fun equals(other: Any?) = false
    override fun hashCode() = TcpCmd.Mail.id.toInt()
}