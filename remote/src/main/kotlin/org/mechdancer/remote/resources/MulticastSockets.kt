package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.dependency.buildView
import java.io.Closeable
import java.net.InetSocketAddress
import java.net.MulticastSocket
import java.net.NetworkInterface
import java.util.concurrent.ConcurrentHashMap

/**
 * 组播套接字资源
 *
 * @param address 组地址
 */
class MulticastSockets(val address: InetSocketAddress) :
    UniqueComponent<MulticastSockets>(), Closeable {
    private val core = ConcurrentHashMap<NetworkInterface, MulticastSocket>()
    val view = buildView(core)

    /**
     * 默认套接字
     *
     * 接收所有到达本机的组播包
     * 不要修改组、超时等状态
     */
    val default by lazy { multicastOn(address, null) }

    /** 获取经由 [parameter] 发送的组播套接字 */
    operator fun get(parameter: NetworkInterface): MulticastSocket =
        core.computeIfAbsent(parameter) { multicastOn(address, parameter) }

    /** 获取指定超时时间 [timeout] 的临时套接字 */
    operator fun get(timeout: Int): MulticastSocket =
        multicastOn(address, null).apply { soTimeout = timeout }

    /** 关闭所有发送套接字 */
    override fun close() =
        core.values
            .toList()
            .also { core.clear() }
            .forEach(MulticastSocket::close)

    private companion object {
        // 构造组播套接字
        fun multicastOn(group: InetSocketAddress, net: NetworkInterface?) =
            MulticastSocket(group.port).apply {
                net?.let(this::setNetworkInterface)
                joinGroup(group.address)
            }
    }
}
