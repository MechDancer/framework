package org.mechdancer.remote

import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.modules.tcpconnection.*
import org.mechdancer.remote.presets.RemoteDsl.Companion.remoteHub
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket
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
            // 接收特定组播包
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
            // 接收 TCP 通信包
            object : MailListener {
                override fun process(sender: String, payload: ByteArray) {
                    TODO("not implemented")
                }

                override fun equals(other: Any?) = false
                override fun hashCode() = 1
            }
        }

        inAddition {
            // 处理特定短连接
            object : ShortConnectionListener {
                override val interest = Cmd.X.id

                override fun process(client: String, socket: Socket) {
                    TODO("not implemented")
                }

                override fun equals(other: Any?) = false
                override fun hashCode() = 2
            }
        }

        inAddition {
            // 处理通用短连接
            CommonTcpServer { sender, socket ->
                log("- hear common by $sender")
                socket.listen()
                socket.say("I see.")
                TODO("添加其他功能")
            }
        }

    }.apply {
        openAllNetworks() // 发/先上线 的要打开，收/后上线 的不用
        thread { while (true) invoke() }
        thread { while (true) accept() }
    }

    hub.connect("receiver", TcpCmd.Mail) { it say ("hello".toByteArray()) }
    hub.connect("receiver", Cmd.X) { it say ("hello".toByteArray()) }
    hub.broadcast(Cmd.X, "hello".toByteArray())
}

fun log(info: Any?) = if (DEBUG) println(info) else Unit