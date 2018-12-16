package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.dependency.unique.UniqueDependencyManager
import org.mechdancer.remote.modules.group.Rule
import org.mechdancer.remote.resources.ServerSockets
import org.mechdancer.remote.resources.TcpCmd
import org.mechdancer.remote.resources.TcpFeedbackCmd
import kotlin.collections.set

/**
 * 短连接服务器
 */
class ShortConnectionServer(private val rule: Rule = Rule()) :
    UniqueComponent<ShortConnectionServer>(), Dependent {

    private val manager = UniqueDependencyManager()

    private val servers by manager.must<ServerSockets>()
    private val mailListener = hashSetOf<MailListener>()
    private val listeners = hashMapOf<Byte, ShortConnectionListener>()

    override fun sync(dependency: org.mechdancer.dependency.Component): Boolean {
        manager.sync(dependency)
        if (dependency is MailListener)
            mailListener.add(dependency)
        if (dependency is ShortConnectionListener)
            listeners[dependency.interest] = dependency
        return false
    }

    operator fun invoke(port: Int = 0) {
        servers[port]!!
            .accept()
            .use { socket ->
                val cmd = socket.listenCommand()
                val client = socket.listenString()

                if (rule decline client)
                    socket say TcpFeedbackCmd.DECLINE
                else when (cmd) {
                    TcpCmd.Mail.id -> {
                        val payload = socket.listen()
                        for (listener in mailListener)
                            listener.process(client, payload)
                    }
                    else           ->
                        listeners[cmd]?.process(client, socket)
                }
            }
    }
}
