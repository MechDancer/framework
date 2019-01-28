package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.*
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
class MulticastBroadcaster(size: Int = 0x4000) :
    UniqueComponent<MulticastBroadcaster>(), Dependent {

    private val manager = DependencyManager()

    private val name by manager.maybe("") { it: Name -> it.field } // 可以匿名发送组播
    private val slicer by manager.maybe<PacketSlicer>()
    private val sockets by manager.must<MulticastSockets>()

    private val stub by lazy {
        SimpleOutputStream(size).apply { writeEnd(name) }
    }

    override fun sync(dependency: Component) = manager.sync(dependency)

    fun broadcast(cmd: Command, payload: ByteArray = ByteArray(0)) {
        if (name.isEmpty() && (cmd == UdpCmd.YELL_ACK || cmd == UdpCmd.ADDRESS_ACK)) return

        val stream = stub.clone()
        fun send() {
            val packet = DatagramPacket(stream.core, stream.ptr, sockets.address)
            for (socket in sockets.view.values)
                socket.send(packet)
        }

        when {
            // 一包能发
            stream.available() - 1 >= payload.size -> {
                stream.write(cmd.id)
                stream.write(payload)
                send()
            }
            // 可以分包
            slicer != null                         -> {
                stream.write(UdpCmd.PACKET_SLICE.id)
                val position = stream.ptr
                slicer!!.broadcast(cmd, payload, stream.available()) {
                    stream.ptr = position
                    stream.write(it)
                    send()
                }
            }
            // 否则
            else                                   ->
                throw RuntimeException("payload is too heavy!")
        }
    }
}
