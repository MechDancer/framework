package org.mechdancer.remote.resources

import org.mechdancer.remote.resources.Command.Companion.memoryOf

/**
 * 组播协议
 */
enum class UdpCmd(override val id: Byte) : Command {
    YELL_ASK(0),     // 存在性请求
    YELL_ACK(1),     // 存在性回复
    ADDRESS_ASK(2),  // 地址请求
    ADDRESS_ACK(3),  // 地址回复
    PACKET_SLICE(4), // 包分片
    COMMON(127);     // 通用广播

    companion object {
        private val memory = memoryOf<UdpCmd>()
        operator fun get(id: Byte) = memory[id]
    }
}
