package org.mechdancer.encoder

import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.zigzag
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

/**
 * 结构描述管理
 */
class StructMonitor {
    private val lock = ReentrantReadWriteLock()
    private val core = mutableMapOf<String, StructDescription>()

    /** 构造节点的完整描述 */
    fun buildDescription(name: String): ByteArray {
        val (root, temp) = lock.read {
            val r = core[name] ?: throw RuntimeException("detected unknown struct $name")
            r to mutableSetOf<StructDescription>().also { addDependenciesTo(it, r) }
        }

        val list = temp.apply {
            remove(root)
            removeIf { it.fields.isEmpty() }
        }

        return ByteArrayOutputStream()
            .also { stream ->
                stream.zigzag((list.size + 1).toLong(), false)
                root.writeTo(stream)
                for (sub in list) sub.writeTo(stream)
            }
            .toByteArray()
    }

    /** 添加节点描述 */
    fun add(struct: StructDescription) =
        lock.write { core[struct.name] = struct }

    /** 分析结构描述并添加 */
    fun analysis(stream: InputStream) =
        when (val count = stream.zigzag(false).toInt()) {
            0    -> stream.readEnd()
            else -> List(count) { StructDescription.readFrom(stream) }
                .also { list -> lock.write { for (it in list) core[it.name] = it } }
                .first()
                .name
        } to stream.readBytes()

    // 递归构造无环路的依赖集合
    private fun addDependenciesTo(
        target: MutableSet<StructDescription>,
        root: StructDescription
    ) {
        if (!target.add(root)) return
        for ((sub, _) in root.fields)
            core[sub]
                ?.let { addDependenciesTo(target, it) }
                ?: throw RuntimeException("detected unknown struct $sub")
    }
}
