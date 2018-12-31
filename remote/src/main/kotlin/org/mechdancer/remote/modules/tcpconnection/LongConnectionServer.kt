package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.remote.resources.TcpCmd
import java.net.Socket
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

/**
 * 长连接收发
 */
class LongConnectionServer(
    private val block: (ByteArray) -> ByteArray?
) : ConnectionListener {
    override val interest = TcpCmd.Blocking

    private val lock = ReentrantReadWriteLock()
    private var pipe: Pair<String, Socket>? = null

    /** 查看当前连接到的客户 */
    val client get() = lock.read { pipe?.first }

    /** 发 */
    fun call(payload: ByteArray): ByteArray? =
        lock.read {
            val (_, server) = pipe ?: return null
            server.say(payload)
            server.listen()
        }

    override fun process(client: String, socket: Socket) =
        null == lock.write {
            socket
                .takeIf { pipe == null }
                ?.also { pipe = client to socket }
        }?.also {
            while (socket.listen().let(block)?.let(socket::say) != null);
            lock.write { pipe = null }
        }

    override fun equals(other: Any?) = this === other
    override fun hashCode() = interest.id.toInt()
}