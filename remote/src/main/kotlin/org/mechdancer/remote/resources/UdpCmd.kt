package org.mechdancer.remote.resources

import org.mechdancer.remote.resources.Command.Companion.memoryOf

/**
 * 组播协议
 */
enum class UdpCmd(override val id: Byte) : Command {
    /** 存在性请求 */
    YELL_ASK(0),
    /** 存在性回复 */
    YELL_ACK(1),
    /** 地址请求 */
    ADDRESS_ASK(2),
    /** 地址回复 */
    ADDRESS_ACK(3),
    /** 包分片 */
    PACKET_SLICE(4),
    /** 话题消息 */
    TOPIC_MESSAGE(5),
    /** 通用广播 */
    COMMON(127);

    companion object {
        private val memory = memoryOf<UdpCmd>()
        operator fun get(id: Byte) = memory[id]
    }
}
