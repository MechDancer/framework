package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.resources.LongConnectionSockets
import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket

/**
 * 长连接管理（对等）
 */
class LongConnectionMonitor :
    UniqueComponent<LongConnectionMonitor>(),
    Dependent {
    private val manager = DependencyManager()

    private val client by manager.must<ConnectionClient>()
    private val sockets by manager.must<LongConnectionSockets>()

    override fun sync(dependency: Component) =
        manager.sync(dependency)

    /** 找到与 [name] 的连接或建立新的连接 */
    fun connect(name: String) =
        sockets.getOrSet(name) { client.connect(name, TcpCmd.Blocking) }

    /** 关闭与 [name] 的连接 */
    fun close(name: String) =
        sockets.close(name)

    /** 使用与 [name] 的连接通信 */
    fun <T> process(name: String, block: (Socket) -> T): T? {
        val socket = connect(name) ?: return null
        return socket
            .runCatching(block)
            .onFailure {
                System.err.println("an exception was caught during the connection:")
                it.printStackTrace()
            }
            .getOrNull()
    }
}
