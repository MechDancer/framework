package org.mechdancer.remote.presets

import org.mechdancer.dependency.scope
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.resources.MulticastSockets
import org.mechdancer.remote.resources.Networks
import org.mechdancer.remote.resources.UdpCmd
import org.slf4j.Logger
import java.net.InetSocketAddress
import java.util.*

/**
 * 起搏器
 *
 * 为了兼顾灵活性与性能，建议使用起搏器打开网络端口。
 * 使用方法：
 * 1. 其他远程节点绑定所有本地网络接口，但不打开任何接口。
 * 2. 构造起搏器，定时进行触发。
 * 3. 收到起搏器激发包的远程节点将打开正确的网络接口。
 *
 * @param group 组播地址和端口
 */
class Pacemaker(
    val group: InetSocketAddress,
    loggerSetting: (Logger.() -> Unit)?
) {
    private val networks = Networks()
    private val sockets = MulticastSockets(group)
    private val broadcaster = MulticastBroadcaster()

    init {
        scope {
            setup(networks)
            setup(sockets)
            setup(broadcaster)
            loggerSetting?.let { setup(ScopeLogger("Pacemaker[${UUID.randomUUID()}]", it)) }
        }
        scan()
    }

    /** 重新扫描并打开所有本地网络接口 */
    fun scan() {
        networks.scan()
        for (network in networks.view.keys)
            sockets[network]
    }

    /** 发送激发包 */
    operator fun invoke() =
        broadcaster.broadcast(UdpCmd.YELL_ASK)
}
