package org.mechdancer.remote.resources

enum class TcpFeedbackCmd(override val id: Byte) : Command {
    DECLINE(0);

    companion object {
        private val memory = Command.memoryOf<TcpFeedbackCmd>()
        operator fun get(id: Byte) = memory[id]
    }
}