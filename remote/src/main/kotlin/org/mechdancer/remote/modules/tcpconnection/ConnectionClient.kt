package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.group.GroupMonitor
import org.mechdancer.remote.resources.Addresses
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.Name
import java.io.IOException
import java.net.Socket
import java.net.SocketException

/**
 * 短连接客户端
 */
class ConnectionClient : UniqueComponent<ConnectionClient>(), Dependent {
    private val manager = DependencyManager()

    private val name by manager.mustUnique { x: Name -> x.field }
    private val ask by manager.maybe(null) { x: PortMonitor -> x::ask }
    private val addresses by manager.must<Addresses>()
    private val groupMonitor by manager.maybe<GroupMonitor>()
    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    /**
     * 连接一个远端
     * @param server 远端名字
     */
    fun connect(server: String, cmd: Command): Socket? {
        val address =
            addresses[server] ?: run {
                ask?.invoke(server)
                logger?.warn(unknown(server))
                return null
            }

        val socket = Socket()
        return try {
            socket.also { I ->
                I.connect(address)
                I say cmd
                I say name
                groupMonitor?.detect(server)
                logger?.info(connected(server, cmd))
            }
        } catch (e: SocketException) {
            addresses remove server
            ask?.invoke(server)
            logger?.info(failed(server))
            null
        } catch (e: IOException) {
            socket.close()
            logger?.error(error(server))
            null
        }
    }

    private companion object {
        fun unknown(server: String) = "$server's address is unknown, please retry later"
        fun connected(server: String, cmd: Command) = "connected to $server using $cmd"
        fun failed(server: String) = "connect to $server failed using current address, please retry later"
        fun error(server: String) = "an IOException was caught during the connection to $server creating"
    }
}
