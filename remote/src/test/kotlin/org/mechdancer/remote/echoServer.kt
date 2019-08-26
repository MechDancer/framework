package org.mechdancer.remote

import org.mechdancer.remote.modules.tcpconnection.connectionListener
import org.mechdancer.remote.modules.tcpconnection.listenString
import org.mechdancer.remote.modules.tcpconnection.say
import org.mechdancer.remote.presets.remoteHub
import org.mechdancer.remote.resources.TcpCmd
import kotlin.concurrent.thread

private object Server1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val hub = remoteHub("kotlin echo server") {
            inAddition {
                connectionListener { client, I ->
                    client
                        .endsWith("client") // 只接受名称符合规则的连接
                        .also {
                            if (it) {
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
        val hub = remoteHub("kotlin client")
        hub.openFirstNetwork()
        thread(isDaemon = true) { while (true) hub() }
        while (null == hub.connect("kotlin echo server", TcpCmd.COMMON) {
                while (true) {
                    val msg = readLine()!!
                    it.say(msg)
                    if (msg == "over") break
                    println(it.listenString())
                }
            }) Thread.sleep(100)
    }
}
