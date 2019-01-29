package org.mechdancer.remote.modules.group

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.resources.Group
import org.mechdancer.remote.resources.UdpCmd

/**
 * 组成员的管理器
 *
 * 监听到达节点的所有通信，包括UDP和TCP
 */
class GroupMonitor : UniqueComponent<GroupMonitor>(),
                     Dependent {

    private val manager = DependencyManager()

    private val update by manager.mustUnique { it: Group -> it::detect }
    private val broadcaster by manager.maybe<MulticastBroadcaster>()
    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    /** 请求组中的成员响应，以证实存在性，要使用此功能必须依赖组播发送 */
    fun yell() {
        broadcaster!!.broadcast(UdpCmd.YELL_ASK)
        logger?.debug("yelled")
    }

    /** 更新[node]出现时间并回复 */
    fun detect(node: String, reply: Boolean = false) {
        // 只保存非匿名对象
        if (node.isNotBlank())
            update(node) ?: logger?.info("detect $node")
        // 回应询问
        if (reply) {
            broadcaster?.broadcast(UdpCmd.YELL_ACK)
            logger?.debug("reply yelling from $node")
        }
    }
}
