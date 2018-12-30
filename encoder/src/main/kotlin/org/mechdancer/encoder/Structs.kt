package org.mechdancer.encoder

import org.mechdancer.encoder.util.writeEnd
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read

class Structs {
    private val lock = ReentrantReadWriteLock()
    private val core = mutableMapOf<String, StructDescription>()

    /** 构造节点的完整描述 */
    fun buildDescription(name: String) =
        lock.read {
            val root =
                core[name] ?: throw RuntimeException("detected unknown struct $name")
            val stream = ByteArrayOutputStream()
            stream.writeDescription(root)
            mutableSetOf<StructDescription>()
                .also { addDependenciesTo(it, root) }
                .also { it.remove(root) }
                .forEach(stream::writeDescription)
            stream.toByteArray()
        }

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

// 描述符输出到流
private fun OutputStream.writeDescription(
    struct: StructDescription
) {
    writeEnd(struct.name)
    for ((name, type) in struct.fields) {
        writeEnd(name)
        write(type.id)
    }
    write(0)
}