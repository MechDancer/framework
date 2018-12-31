package org.mechdancer.encoder

import org.mechdancer.encoder.core.Field
import org.mechdancer.encoder.core.Graph
import org.mechdancer.encoder.core.Property
import org.mechdancer.encoder.core.take
import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.writeEnd
import org.mechdancer.encoder.util.zigzag
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

/**
 * 类型图
 */
class TypeGraph<T : Map<String, Iterable<Field>>>
    (core: T) : Graph<String, Field, T>(core, { it.type }) {

    /** 从[root]生成结构的完整描述 */
    fun serialize(root: String) =
        ByteArrayOutputStream()
            .apply {
                val (head, tail) = subWith(root).take(root)
                zigzag(tail.size + 1L, false)
                writeDescription(head.first, head.second!!)
                for ((type, fields) in tail) writeDescription(type, fields)
            }
            .toByteArray()

    companion object {
        /** 从[root]生成结构的完整描述 */
        fun deserialize(stream: InputStream) =
            (0 until stream.zigzag(false))
                .map { stream.readDescription() }

        // 把一个结构描述写入流
        private fun OutputStream.writeDescription(
            typeName: String,
            fields: Iterable<Field>
        ) {
            writeEnd(typeName)
            for ((name, type, property) in fields) {
                writeEnd(name)
                writeEnd(type)
                write(property.id)
            }
            write(0)
        }

        // 把一个结构描述写入流
        private fun InputStream.readDescription() =
            readEnd() to generateSequence {
                readEnd()
                    .takeIf(String::isNotEmpty)
                    ?.let { name ->
                        Field(name, readEnd(), Property.map[read()]!!)
                    }
            }.toList()
    }
}
