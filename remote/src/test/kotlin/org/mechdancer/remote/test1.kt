package org.mechdancer.remote

import org.mechdancer.remote.modules.multicast.multicastListener
import org.mechdancer.remote.modules.tcpconnection.connectionListener
import org.mechdancer.remote.modules.tcpconnection.mailListener
import org.mechdancer.remote.modules.tcpconnection.say
import org.mechdancer.remote.presets.remoteHub
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.TcpCmd
import kotlin.concurrent.thread

const val DEBUG = true

enum class Cmd(override val id: Byte) : Command { X(100) }

/**
 * 构造并启用收发特定指令的终端
 */
@Suppress("UNUSED_ANONYMOUS_PARAMETER")
fun main() {
    val hub = remoteHub("sender") {
        configLogger { }

        inAddition {
            // 接收特定组播包
            multicastListener(Cmd.X) { sender, cmd, payload ->
                TODO("not implemented")
            }
        }

        inAddition {
            // 接收 TCP 通信包
            mailListener { sender, payload ->
                TODO("not implemented")
            }
        }

        inAddition {
            // 处理特定短连接
            connectionListener(Cmd.X) { client, server ->
                TODO("not implemented")
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

    readLine()
}
