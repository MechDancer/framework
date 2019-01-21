package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
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
        val socket = servers[port]!!.accept()
        var cmd: TcpCmd? = null
        try {
            cmd = TcpCmd[socket.listenCommand()]
            val client = socket.listenString()
            when (cmd) {
                TcpCmd.Mail     ->
                    socket.listen().let { payload ->
                        for (listener in mailListeners)
                            listener.process(client, payload)
                    }
                TcpCmd.Blocking ->
                    longConnectionSockets[client] = socket
                null            -> Unit
                else            ->
                    listeners[cmd.id]?.firstOrNull {
                        it.process(client, socket)
                    }
            }
        } catch (e: Exception) {
            System.err.println("an exception was caught during the connection:")
            e.printStackTrace()
        } finally {
            if (cmd != TcpCmd.Blocking) socket.close()
        }
    }
}
