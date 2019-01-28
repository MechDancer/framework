package org.mechdancer.remote.presets

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.plusAssign
import org.mechdancer.dependency.scope
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.modules.group.GroupMonitor
import org.mechdancer.remote.modules.multicast.MulticastBroadcaster
import org.mechdancer.remote.modules.multicast.MulticastReceiver
import org.mechdancer.remote.modules.multicast.PacketSlicer
import org.mechdancer.remote.modules.tcpconnection.*
import org.mechdancer.remote.resources.*
import org.slf4j.Logger
import java.io.Closeable
import java.net.InetSocketAddress
import java.net.NetworkInterface
import java.net.Socket
import java.util.*

/**
 * 远程终端
 */
class RemoteHub(
    name: String?,
    group: InetSocketAddress,
    sliceSize: Int,
    loggerSetting: Logger.() -> Unit,
    additional: Iterable<Component>
) : Closeable {

    // region members

    // region UDP

    // 组成员资源
    private val _group = Group()
    // 组成员管理
    private val monitor = GroupMonitor()

    // 网络接口资源
    private val networks = Networks()
    // 组播套接字
    private val sockets = MulticastSockets(group)
    // 组播发送器
    private val broadcaster = MulticastBroadcaster(sliceSize)
    // 组播接收器
    private val receiver = MulticastReceiver()
    // 组播分片协议
    private val slicer = PacketSlicer()

    // endregion

    // region TCP

    // 组地址资源
    private val addresses = Addresses()
    // 监听套接字资源
    private val servers = ServerSockets()
    // 组地址同步器
    private val synchronizer1 = PortBroadcaster()
    private val synchronizer2 = PortMonitor()
    // TCP 连接
    private val client = ConnectionClient()
    private val server = ConnectionServer()
    // TCP 长连接
    private val longConnectionSockets = LongConnectionSockets()
    private val longConnectionMonitor = LongConnectionMonitor()

    // endregion

    private val scope = scope {
        // 名字
        val actualName = name ?: "RemoteHub[${UUID.randomUUID()}]"
        this += Name(actualName)

        // 组成员管理
        this += _group  // 成员存在性资源
        this += monitor // 组成员管理

        // 组播
        this += networks    // 本机网络端口资源
        this += sockets     // 组播套接字资源
        this += broadcaster // 组播发送
        this += receiver    // 组播接收
        this += slicer      // 组播分片协议

        // TCP 地址
        this += addresses     // 地址资源
        this += servers       // 监听套接字资源
        this += synchronizer1 // 组地址同步器（答）
        this += synchronizer2 // 组地址同步器（问）

        // TCP 连接
        this += server // 服务端
        this += client // 客户端

        // TCP 长连接
        this += longConnectionSockets
        this += longConnectionMonitor

        // 日志器
        this += ScopeLogger(actualName, loggerSetting)

        for (dependency in additional)
            this += dependency
    }

    // endregion

    // region methods

    // region access

    /** 浏览全部依赖项 */
    val components get() = scope.components

    /** 查看超时时间 [timeout] 内出现的组成员 */
    operator fun get(timeout: Int) = _group[timeout]

    /** 查看远端 [name] 的地址和端口 */
    operator fun get(name: String) =
        _group[name]?.let {
            RemoteInfo(
                name,
                it,
                addresses[name],
                longConnectionSockets[name] != null
            )
        }

    // endregion

    // region networks

    /**
     * 尝试打开一个随机的网络端口，返回是否成功
     * 若当前已有打开的网络端口则不进行任何操作
     */
    fun openFirstNetwork() =
        sockets.view.isNotEmpty()
        || null != networks.view.keys.firstOrNull()?.also { sockets[it] }

    /**
     * 尝试打开一个随机的网络端口，返回是否成功
     * 若当前已有打开的网络端口则不进行任何操作
     */
    fun openFirstNetwork(block: (NetworkInterface) -> Boolean) =
        sockets.view.keys.any(block)
        || null != networks.view.keys.firstOrNull(block)?.also { sockets[it] }

    /**
     * 尝试打开一个随机的网络端口，返回是否成功
     * 若当前已有打开的网络端口则不进行任何操作
     */
    fun openAllNetworks(block: (NetworkInterface) -> Boolean): Int {
        for (network in networks.view.keys.filter(block))
            sockets[network]
        return sockets.view.size
    }

    /** 打开所有网络端口，返回实际打开的网络端口数量 */
    fun openAllNetworks(): Int {
        for (network in networks.view.keys)
            sockets[network]
        return sockets.view.size
    }

    // endregion

    // region service

    /** 阻塞等待 UDP 报文 */
    operator fun invoke() = receiver()

    /** 阻塞等待 TCP 连接 */
    fun accept() = server()

    // endregion

    // region function

    /** 请求自证存在性 */
    fun yell() = monitor.yell()

    /** 主动询问所有远端的端口 */
    fun askEveryone() = synchronizer2.askEveryone()

    /** 主动询问一个远端的端口 */
    infix fun ask(name: String) = synchronizer2.ask(name)

    /** 使用指令 [cmd] 广播数据包 [payload] */
    fun broadcast(cmd: Command, payload: ByteArray) =
        broadcaster.broadcast(cmd, payload)

    /** 使用指令 [cmd] 连接到一个远端 [name] */
    fun <T> connect(name: String, cmd: Command, block: (Socket) -> T): T? =
        client.connect(name, cmd)?.use(block)

    /** 与 [name] 建立长连接 */
    fun connectKeeping(name: String) =
        longConnectionMonitor.connect(name) != null

    /** 关闭与 [name] 的长连接 */
    fun disconnect(name: String) =
        longConnectionMonitor.close(name)

    /** 使用与 [name] 的连接 */
    fun <T> processConnection(name: String, block: (Socket) -> T) =
        longConnectionMonitor.process(name, block)

    /** 关闭 */
    override fun close() {
        for (component in scope.components)
            (component as? Closeable)?.close()
    }

    // endregion

    // endregion

    data class RemoteInfo(
        val name: String,
        val lastSpeaking: Long,
        val address: InetSocketAddress?,
        val connected: Boolean
    )
}
