package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.dependency.buildView
import java.io.Closeable
import java.net.ServerSocket
import java.util.concurrent.ConcurrentHashMap

/**
 * 监听套接字资源
 */
class ServerSockets(private val port: Int = 0) :
    UniqueComponent<ServerSockets>(), Closeable {
    private val core = ConcurrentHashMap<Int, ServerSocket>()
    val view = buildView(core)

    val default by lazy { ServerSocket(port) }

    fun isClosed() = default.isClosed

    /**
     * 获取或构造新的套接字资源
     *
     * @param parameter 端口号
     * @return 监听套接字
     */
    operator fun get(parameter: Int) =
        if (parameter == 0) default
        else core
            .runCatching {
                computeIfAbsent(parameter) {
                    ServerSocket(parameter)
                }
            }
            .getOrNull()

    /** 关闭所有套接字 */
    override fun close() {
        default.close()
        core.values
            .toList()
            .also { core.clear() }
            .forEach(ServerSocket::close)
    }
}
