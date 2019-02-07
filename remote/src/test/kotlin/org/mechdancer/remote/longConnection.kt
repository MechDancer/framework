package org.mechdancer.remote

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.mechdancer.common.extension.log4j.toConsole
import org.mechdancer.remote.modules.tcpconnection.listenString
import org.mechdancer.remote.modules.tcpconnection.say
import org.mechdancer.remote.presets.remoteHub
import java.util.concurrent.Executors

private object Server2 {
    val name = Server2::class.java.simpleName!!

    @JvmStatic
    fun main(args: Array<String>) {
        val hub = remoteHub(name) {
            configLogger { toConsole() }
        }
        GlobalScope.launch {
            withContext(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
                repeat(3) { launch { while (true) hub.accept() } }
            }
            withContext(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
                repeat(3) { launch { while (true) hub() } }
            }
        }
        while (hub[Client2.name]?.connected != true);
        hub.processConnection(Client2.name) {
            println("- connected")
            while (true) {
                val msg = it.listenString()
                println("- hear $msg")
                if (msg == "over") break // 在商定的条件出现时退出
                it.say("server heard $msg")
            }
        }
    }
}

private object Client2 {
    val name = Client2::class.java.simpleName!!

    @JvmStatic
    fun main(args: Array<String>) {
        val hub = remoteHub(name) {
            configLogger { toConsole() }
        }
        hub.openFirstNetwork()
        GlobalScope.launch { while (true) hub() }
        while (!hub.connectKeeping(Server2.name));
        hub.processConnection(Server2.name) {
            println("- connected")
            while (true) {
                val msg = readLine()!!
                it.say(msg)
                if (msg == "over") break
                println(it.listenString())
            }
        }
    }
}
