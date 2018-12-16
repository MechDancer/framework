package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.unique.UniqueComponent
import org.mechdancer.dependency.unique.UniqueDependencyManager
import org.mechdancer.remote.resources.Addresses
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.Name
import java.net.Socket
import java.net.SocketException

/**
 * 短连接客户端
 */
class ShortConnectionClient : UniqueComponent<ShortConnectionClient>(), Dependent {

    private val manager = UniqueDependencyManager()

    private val name by manager.must { it: Name -> it.field }
    private val addresses by manager.must<Addresses>()
    private val ask by manager.maybe(null) { it: PortMonitor -> it::ask }

    override fun sync(dependency: Component) = manager.sync(dependency)

    /**
     * 连接一个远端
     * @param server 远端名字
     */
    fun connect(server: String, cmd: Command): Socket? {
        val address =
            addresses[server] ?: run {
                ask?.invoke(server)
                return null
            }

        val socket = Socket()
        return try {
            socket.also { I ->
                I.connect(address)
                I say cmd
                I say name
            }
        } catch (e: SocketException) {
            addresses remove server
            ask?.invoke(server)
            null
        }
    }
}
