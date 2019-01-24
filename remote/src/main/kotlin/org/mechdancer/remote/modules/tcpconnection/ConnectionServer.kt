package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.group.GroupMonitor
import org.mechdancer.remote.modules.group.Rule
import org.mechdancer.remote.resources.LongConnectionSockets
import org.mechdancer.remote.resources.ServerSockets
import org.mechdancer.remote.resources.TcpCmd

/**
 * TCP 连接服务器
 */
class ConnectionServer(private val rule: Rule = Rule()) :
    UniqueComponent<ConnectionServer>(), Dependent {

    private val manager = DependencyManager()

    // resources
    private val servers by manager.must<ServerSockets>()
    private val longConnectionSockets by manager.must<LongConnectionSockets>()

    // functions
    private val detect by manager.mustUnique { monitor: GroupMonitor -> monitor::detect }

    // listeners
    private val mailListeners = mutableSetOf<MailListener>()
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
        val socket = servers[port]?.accept() ?: return
        var closable = true
        try {
            val cmd = socket.listenCommand()
            val client = socket.listenString()
            if (!rule.decline(client)) {
                detect(client)
                when (TcpCmd[cmd]) {
                    TcpCmd.Mail     -> {
                        val payload = socket.listen()
                        for (listener in mailListeners)
                            listener.process(client, payload)
                    }
                    TcpCmd.Blocking -> {
                        closable = false
                        longConnectionSockets[client] = socket
                    }
                    else            ->
                        listeners[cmd]?.firstOrNull {
                            it.process(client, socket)
                        }
                }
            }
        } catch (e: Exception) {
            System.err.println("an exception was caught during the connection:")
            e.printStackTrace()
        } finally {
            if (closable) socket.close()
        }
    }
}
