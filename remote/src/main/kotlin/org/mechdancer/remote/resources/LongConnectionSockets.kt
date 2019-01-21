package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.dependency.buildView
import java.io.Closeable
import java.net.Socket
import java.util.concurrent.ConcurrentHashMap

/** 长连接套接字 */
class LongConnectionSockets :
    UniqueComponent<LongConnectionSockets>(), Closeable {
    private val core = ConcurrentHashMap<String, Socket>()
    val view = buildView(core)

    operator fun set(name: String, socket: Socket) {
        core.compute(name) { _, last ->
            last?.close()
            socket
        }
    }

    operator fun get(name: String) =
        core[name]

    fun getOrSet(name: String, block: () -> Socket?) =
        core.compute(name) { _, last -> last ?: block() }

    fun close(name: String) =
        core.remove(name)?.close() != null

    override fun close() =
        core.values
            .toList()
            .also { core.clear() }
            .forEach(Socket::close)
}
