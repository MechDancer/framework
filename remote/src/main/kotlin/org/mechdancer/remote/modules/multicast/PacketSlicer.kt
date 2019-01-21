package org.mechdancer.remote.modules.multicast

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.remote.protocol.RemotePacket
import org.mechdancer.remote.protocol.SimpleInputStream
import org.mechdancer.remote.protocol.SimpleOutputStream
import org.mechdancer.remote.protocol.zigzag
import org.mechdancer.remote.resources.Command
import org.mechdancer.remote.resources.UdpCmd
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import kotlin.collections.set

/**
 * 数据包分片协议
 */
class PacketSlicer : UniqueComponent<PacketSlicer>(),
                     Dependent,
                     MulticastListener {

    private val sequence = AtomicLong(0)
    private val buffers = ConcurrentHashMap<PackInfo, Buffer>()
    private val listeners = mutableListOf<MulticastListener>()

    override fun sync(dependency: Component): Boolean {
        if (dependency is MulticastListener)
            listeners.add(dependency)
        return false
    }

    override val interest = INTEREST

    /**
     * 使用分片协议广播一包
     * @param cmd     实际指令
     * @param payload 实际数据
     * @param size    分片数据长度
     * @param output  发布方法
     */
    internal fun broadcast(
        cmd: Command,
        payload: ByteArray,
        size: Int,
        output: (ByteArray) -> Unit
    ) {
        val stream = SimpleInputStream(payload)
        val s = sequence.incrementAndGet().zigzag(false)
        var index = 0L // 包序号

        while (stream.available() > 0) {
            // 编码子包序号
            val i = index++.zigzag(false)
            // 如果是最后一包，应该多长?
            val last = stream.available() + 2 + s.size + i.size
            // 打包
            with(
                if (last <= size)
                    SimpleOutputStream(last)
                        .apply {
                            write(0)      // 空一位作为停止位
                            write(cmd.id) // 保存实际指令
                        }
                else SimpleOutputStream(size)
            ) {
                write(s)
                write(i)
                writeFrom(stream, available())
                output(core)
            }
        }
    }

    override fun process(remotePacket: RemotePacket) {
        val (name, _, payload) = remotePacket

        val stream = SimpleInputStream(payload) // 构造流
        val cmd =
            stream.takeIf { it.look() == LAST } // 判断停止位
                ?.skip(1)                       // 跳过停止位和指令位
                ?.read()
                ?.toByte()
        val subSeq = stream.zigzag(false) // 解子包序列号
        val index = stream.zigzag(false)  // 解子包序号
        val rest = stream.lookRest()      // 解子包负载

        when { // 这是第一包也是最后一包 => 只有一包 => 不进缓存
            index == 0L && cmd != null -> cmd to rest
            else                       ->
                PackInfo(name, subSeq).let { key ->
                    buffers
                        .computeIfAbsent(key) { Buffer() }
                        .put(cmd, index.toInt(), rest)
                        ?.also { buffers.remove(key) }
                }
        }
            ?.let { (cmd, payload) -> RemotePacket(name, cmd, payload) }
            ?.let { pack ->
                listeners
                    .filter { pack.command in it.interest.map(Command::id) }
                    .forEach { it process pack }
            }
    }

    /** 清理缓冲中最后活跃时间超过 [timeout]ms 的数据包 */
    fun refresh(timeout: Int) {
        val now = System.currentTimeMillis()
        buffers // 删除超时包
            .filterValues { it by now > timeout }
            .keys.forEach { buffers.remove(it) }
    }

    /** 关键信息 */
    private data class PackInfo(val name: String, val seq: Long)

    /** 子包缓存 */
    private class Buffer {
        private var time = System.currentTimeMillis()

        private val list = mutableListOf<Hook>()
        private val mark = hashMapOf<Int, Hook>()

        private var command: Byte? = null
        private val done get() = command != null

        /** @return 最后活跃时间到当前的延时 */
        infix fun by(now: Long) = now - time

        /**
         * 置入一个小包
         * @param cmd     包指令
         * @param index   序号
         * @param payload 负载
         *
         * @return 已完结则返回完整包
         */
        fun put(
            cmd: Byte?,
            index: Int,
            payload: ByteArray
        ): Pair<Byte, ByteArray>? {
            // 修改状态，加锁保护
            synchronized(list) {
                if (done) mark.remove(index)!!.ptr = payload
                else {
                    command = cmd

                    for (i in list.size until index) {
                        val hook = Hook(null)
                        mark[i] = hook
                        list.add(hook)
                    }

                    if (list.size != index)
                        mark.remove(index)!!.ptr = payload
                    else
                        list.add(Hook(payload))
                }
            }

            // 已经保存最后一包并且不缺包
            if (done && mark.isEmpty())
                return command!! to SimpleOutputStream(list.sumBy { it.ptr!!.size })
                    .apply { for (sub in list) write(sub.ptr!!) }
                    .core

            // 更新最后活跃时间
            time = System.currentTimeMillis()
            return null
        }

        private class Hook(var ptr: ByteArray?)
    }

    private companion object {
        val INTEREST = setOf(UdpCmd.PACKET_SLICE)
        const val LAST = 0.toByte()
    }
}
