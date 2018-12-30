package org.mechdancer.encoder

import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.writeEnd
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

/**
 * 结构
 * @param name   唯一名字
 * @param fields 字段和特性列表
 */
class Struct(
    val name: String,
    val fields: List<Pair<Struct, FieldType>>
) {
    init {
        assert(name.isNotBlank())
    }

    /**
     * 生成描述符
     */
    val description
        get() = ByteArrayOutputStream()
            .apply {
                writeDescription(this)
                mutableSetOf<Struct>()
                    .apply(this@Struct::buildDependencies)
                    .apply { remove(this@Struct) }
                    .forEach { it.writeDescription(this) }
            }

    override fun equals(other: Any?) = (other as? Struct)?.name == name
    override fun hashCode() = name.hashCode()

    // 构造无环路的依赖集合
    private fun buildDependencies(set: MutableSet<Struct>) {
        if (set.add(this))
            fields.forEach { (sub, _) -> sub.buildDependencies(set) }
    }

    // 描述符输出到流
    private fun writeDescription(stream: OutputStream) {
        stream.writeEnd(name)
        for ((struct, type) in fields) {
            stream.writeEnd(struct.name)
            stream.write(type.id)
        }
        stream.write(0)
    }

    companion object {
        fun readDescription(stream: InputStream) =
            stream.readEnd() to generateSequence {
                stream.readEnd()
                    .takeIf(String::isNotBlank)
                    ?.let { it to FieldType.values().find { it.id == stream.read() } }
            }.toList()
    }
}