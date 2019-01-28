package org.mechdancer.remote.protocol

/**
 * 通用数据包
 * 用于无连接通信或建立连接
 *
 * @param command   指令识别号
 * @param sender    发送方名字
 * @param payload   数据负载
 */
class RemotePacket(
    val sender: String,
    val command: Byte,
    val payload: ByteArray
) {
    operator fun component1() = sender
    operator fun component2() = command
    operator fun component3() = payload

    override fun toString() =
        "packet{$command, payload length = ${payload.size}} from \"$sender\""
}
