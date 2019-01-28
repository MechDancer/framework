package org.mechdancer.remote.presets

import org.mechdancer.dependency.scope
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.group.GroupMonitor
import org.mechdancer.remote.modules.multicast.MulticastReceiver
import org.mechdancer.remote.modules.tcpconnection.PortMonitor
import org.mechdancer.remote.resources.Addresses
import org.mechdancer.remote.resources.Group
import org.mechdancer.remote.resources.MulticastSockets
import org.slf4j.Logger
import java.net.InetSocketAddress
import java.util.*

/**
 * 探针
 *
 * @param group 组播地址和端口
 */
class Probe(
    name: String? = null,
    val group: InetSocketAddress = Default.GROUP,
    loggerSetting: Logger.() -> Unit = Default.LOGGER_SETTING
) {
    private val _group = Group()
    private val addresses = Addresses()

    private val sockets = MulticastSockets(group)
    private val groupMonitor = GroupMonitor()
    private val receiver = MulticastReceiver()

    init {
        scope {
            setup(_group)
            setup(addresses)
            setup(groupMonitor)
            setup(PortMonitor())

            setup(sockets)
            setup(receiver)

            setup(ScopeLogger(name ?: "Probe[${UUID.randomUUID()}]", loggerSetting))
        }
    }

    val view
        get() = _group.view.mapValues { (name, time) ->
            time to addresses[name]
        }

    operator fun get(timeout: Int) = _group[timeout]
    operator fun get(name: String) = _group[name] to addresses[name]

    operator fun invoke() = receiver.invoke()
}
