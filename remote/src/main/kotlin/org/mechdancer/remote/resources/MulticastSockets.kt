package org.mechdancer.remote.resources

import org.mechdancer.dependency.buildView
import org.mechdancer.dependency.unique.UniqueComponent
import java.net.InetSocketAddress
import java.net.MulticastSocket
import java.net.NetworkInterface
import java.util.concurrent.ConcurrentHashMap

/**
 * 组播套接字资源
 * @param address 组地址
 */
class MulticastSockets(val address: InetSocketAddress) : UniqueComponent<MulticastSockets>() {

    private val core = ConcurrentHashMap<NetworkInterface, MulticastSocket>()
    val view = buildView(core)

    /**
     * 默认套接字
     * 接收所有到达本机的组播包
     * 不要修改组、超时等状态
     */
    val default by lazy { multicastOn(address, null) }

    /**
     * 获取经由特定网络端口的组播套接字
     */
    operator fun get(parameter: NetworkInterface): MulticastSocket =
        core.computeIfAbsent(parameter) { multicastOn(address, parameter) }

    /**
     * 获取指定超时时间的临时套接字
     */
    operator fun get(timeout: Int): MulticastSocket =
        multicastOn(address, null).apply { soTimeout = timeout }

    private companion object {
        // 构造组播套接字
        fun multicastOn(group: InetSocketAddress, net: NetworkInterface?) =
            MulticastSocket(group.port).apply {
                net?.let(this::setNetworkInterface)
                joinGroup(group.address)
            }
    }
}
