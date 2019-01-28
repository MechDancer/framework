package org.mechdancer.remote.modules.group

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.modules.multicast.MulticastListener
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.Group
import org.mechdancer.remote.resources.Name
import org.mechdancer.remote.resources.UdpCmd

/**
 * 组成员的管理器
 *   发现新成员时会自动调用函数 [detected]
 *   从未出现过的成员或离线时间超过超时时间 [timeout] 的成员出现时视作新成员
 */
class GroupMonitor(
    private val detected: (String) -> Unit = {},
    private val timeout: Int = Int.MAX_VALUE
) : UniqueComponent<GroupMonitor>(), Dependent, MulticastListener {

    private val manager = DependencyManager()

    private val nameExist by manager.maybe(false) { it: Name -> it.field.isNotBlank() }
    private val update by manager.mustUnique { it: Group -> it::detect }
    private val broadcaster by manager.maybe<MulticastBroadcaster>()
    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    /** 请求组中的成员响应，以证实存在性，要使用此功能必须依赖组播发送 */
    fun yell() {
        broadcaster!!.broadcast(UdpCmd.YELL_ASK)
        logger?.trace("yelled")
    }

    /** 更新[node]出现时间 */
    fun detect(node: String) {
        if (node.isNotBlank()) // 只保存非匿名对象
            update(node)
                ?.takeUnless { System.currentTimeMillis() - it > timeout }
            ?: run {
                logger?.info("detect $node")
                detected(node)
            }
    }

    override val interest = INTEREST

    override fun process(remotePacket: RemotePacket) {
        val (node, cmd) = remotePacket

        detect(node)

        // 回应询问
        if (cmd == UdpCmd.YELL_ASK.id && nameExist) {
            broadcaster?.broadcast(UdpCmd.YELL_ACK)
            logger?.trace("reply yelling from $node")
        }
    }

    private companion object {
        val INTEREST = setOf<Command>()
    }
}
