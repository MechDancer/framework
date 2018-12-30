package org.mechdancer.remote

import org.mechdancer.remote.RemoteDsl.Companion.remoteHub
import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.modules.tcpconnection.MailListener
import org.mechdancer.remote.modules.tcpconnection.say
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.TcpCmd
import kotlin.concurrent.thread

const val DEBUG = true

enum class Cmd(override val id: Byte) : Command { X(100) }

/**
 * 构造并启用收发特定指令的终端
 */
fun main() {
    val hub = remoteHub("sender") {
        newMemberDetected { log("- detected $it in LAN") }

        inAddition {
            object : MulticastListener {
                override val interest = listOf(Cmd.X.id)
                override fun process(remotePacket: RemotePacket) {
                    val (sender, _, payload) = remotePacket
                    TODO("not implemented")
                }

                override fun equals(other: Any?) = false
                override fun hashCode() = 0
            }
        }

        inAddition {
            object : MailListener {
                override fun process(sender: String, payload: ByteArray) {
                    TODO("not implemented")
                }

                override fun equals(other: Any?) = false
                override fun hashCode() = 1
            }
        }
    }.apply {
        openAllNetworks() // 发/先上线 的要打开，收/后上线 的不用
        thread { while (true) invoke() }
        thread { while (true) accept() }
    }

    hub.connect("receiver", TcpCmd.Mail) { it say ("hello".toByteArray()) }
    hub.broadcast(Cmd.X, "hello".toByteArray())
}

fun log(info: Any?) = if (DEBUG) println(info) else Unit