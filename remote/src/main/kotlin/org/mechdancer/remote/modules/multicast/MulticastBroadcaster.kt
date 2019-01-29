package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.*
import org.mechdancer.remote.modules.ScopeLogger
import org.mechdancer.remote.protocol.SimpleOutputStream
import org.mechdancer.remote.protocol.writeEnd
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.MulticastSockets
import org.mechdancer.remote.resources.Name
import org.mechdancer.remote.resources.UdpCmd
import java.net.DatagramPacket

/**
 * 组播发布者
 *
 * @param size UDP 包分片长度
 */
class MulticastBroadcaster(size: Int = 0x4000)
    : UniqueComponent<MulticastBroadcaster>(),
      Dependent {

    private val manager = DependencyManager()

    private val name by manager.maybe("") { x: Name -> x.field }
    // 用于发送的依赖
    private val sockets by manager.must<MulticastSockets>()
    private val slicer by manager.maybe<PacketSlicer>()
    // 发送流存根，发送包从这个流复制
    private val stub by lazy { SimpleOutputStream(size).apply { writeEnd(name) } }
    // 日志器
    private val logger by manager.maybe<ScopeLogger>()

    override fun sync(dependency: Component) = manager.sync(dependency)

    /** 通过组播发送: <[cmd]: Byte><[name]: 0结尾字符串><[payload]> */
    fun broadcast(cmd: Command, payload: ByteArray = ByteArray(0)) {
        if (name.isEmpty() && (cmd == UdpCmd.YELL_ACK || cmd == UdpCmd.ADDRESS_ACK)) return

        // 创建存根的副本，整个发送过程是同步的，若需要发送多包则复用同一个副本
        val stream = stub.clone()
        // 从所有打开的套接字同时发送
        fun send() {
            val packet = DatagramPacket(stream.core, stream.ptr, sockets.address)
            for (socket in sockets.view.values) socket.send(packet)
        }
        // 保存发送器
        val broadcaster = slicer?.let { it::broadcast }
        when {
            // 一包能发
            stream.available() - 1 >= payload.size -> {
                stream.write(cmd.id)
                stream.write(payload)
                send()
                logger?.debug("packet sent")
            }
            // 可以分包
            broadcaster != null                    -> {
                stream.write(UdpCmd.PACKET_SLICE.id)
                val position = stream.ptr
                var i = 0
                broadcaster(cmd, payload, stream.available()) {
                    ++i
                    stream.ptr = position
                    stream.write(it)
                    send()
                }
                logger?.debug("packet sent on $i slices")
            }
            // 否则
            else                                   -> {
                logger?.error(tooHeavy(stream.available() - 1))
                throw RuntimeException("payload is too heavy!")
            }
        }
    }

    private companion object {
        fun tooHeavy(size: Int) =
            "try to send a packet longer than $size without ${PacketSlicer::class.java.simpleName}"
    }
}
