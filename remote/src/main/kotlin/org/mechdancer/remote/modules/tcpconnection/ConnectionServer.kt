package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
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
    private val groupMonitor by manager.maybe<GroupMonitor>()

    // listeners
    private val mailListeners = mutableSetOf<MailListener>()
    private val listeners = hashMapOf<Byte, MutableSet<ConnectionListener>>()

    private val logger by manager.maybe<ScopeLogger>()

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
        logger?.info("waiting for connection...")
        val socket = servers[port]?.accept() ?: return
        var closable = true
        try {
            val cmd = socket.listenCommand()
            val client = socket.listenString()
            if (!rule.decline(client)) {
                groupMonitor?.detect(client)
                logger?.info("accepted $client using ${TcpCmd[cmd] ?: cmd}")
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
            logger?.error("an exception was caught during the connection")
        } finally {
            if (closable) socket.close()
        }
    }
}
