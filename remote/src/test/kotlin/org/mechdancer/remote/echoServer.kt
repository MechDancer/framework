package org.mechdancer.remote

import org.mechdancer.remote.modules.tcpconnection.connectionListener
import org.mechdancer.remote.modules.tcpconnection.listenString
import org.mechdancer.remote.modules.tcpconnection.say
import org.mechdancer.remote.presets.RemoteDsl.Companion.remoteHub
import org.mechdancer.remote.resources.TcpCmd
import kotlin.concurrent.thread

private object Server1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val hub = remoteHub("kotlin echo server") {
            newMemberDetected { println("- detected $it") }
            inAddition {
                connectionListener { client, I ->
                    client
                        .endsWith("client") // 只接受名称符合规则的连接
                        .also {
                            if (it) {
                                println("- $client connected")
                                while (true) {
                                    val msg = I.listenString()
                                    println("- hear $msg")
                                    if (msg == "over") break // 在商定的条件出现时退出
                                    I.say("server heard $msg")
                                }
                                println("- $client disconnected")
                            }
                        }
                }
            }
        }

        // 允许同时接收 3 个客户端连接
        repeat(3) { thread { while (true) hub.accept() } }
        while (true) hub()
    }
}

private object Client1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val hub = remoteHub("kotlin client") {
            newMemberDetected { println("- detected $it") }
        }
        hub.openFirst { "VM" !in it.name } // VMware的虚拟网卡服务似乎承接组播不正常
        thread(isDaemon = true) { while (true) hub() }
        while (null == hub.connect("kotlin echo server", TcpCmd.COMMON) {
                println("- connected")
                while (true) {
                    val msg = readLine()!!
                    it.say(msg)
                    if (msg == "over") break
                    println(it.listenString())
                }
            });
    }
}