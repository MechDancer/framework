package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.dependency.unique.UniqueDependencyManager
import org.mechdancer.remote.modules.group.Rule
import org.mechdancer.remote.resources.LongConnectionSockets
import org.mechdancer.remote.resources.ServerSockets
import org.mechdancer.remote.resources.TcpCmd
import org.mechdancer.remote.resources.TcpFeedbackCmd

/**
 * TCP 连接服务器
 */
class ConnectionServer(private val rule: Rule = Rule()) :
    UniqueComponent<ConnectionServer>(), Dependent {

    private val manager = UniqueDependencyManager()

    private val servers by manager.must<ServerSockets>()
    private val mailListeners = mutableSetOf<MailListener>()
    private val longConnectionSockets by manager.must<LongConnectionSockets>()
    private val listeners = hashMapOf<Byte, MutableSet<ConnectionListener>>()

    override fun sync(dependency: Component): Boolean {
        manager.sync(dependency)
        if (dependency is MailListener)
            mailListeners.add(dependency)
        if (dependency is ConnectionListener)
            listeners.compute(dependency.interest.id) { _, list ->
                list?.apply { add(dependency) } ?: mutableSetOf(dependency)
            }
        return false
    }

    /** 打开特定 [port] 接收TCP连接 */
    operator fun invoke(port: Int = 0) {
        servers[port]!!
            .accept()
            .runCatching {
                use { socket ->
                    val cmd = socket.listenCommand()
                    val client = socket.listenString()

                    if (rule decline client)
                        socket say TcpFeedbackCmd.DECLINE
                    else when (cmd) {
                        TcpCmd.Mail.id     -> {
                            val payload = socket.listen()
                            for (listener in mailListeners)
                                listener.process(client, payload)
                        }
                        TcpCmd.Blocking.id ->
                            longConnectionSockets[client] = socket
                        else               ->
                            listeners[cmd]?.firstOrNull {
                                it.process(client, socket)
                            }
                    }
                }
            }
            .onFailure {
                System.err.println("an exception was caught during the connection:")
                it.printStackTrace()
            }
    }
}
