package org.mechdancer.encoder

import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.writeEnd
import java.io.InputStream
import java.io.OutputStream

/**
 * 结构描述符
 */
data class StructDescription(
    val name: String,
    val fields: List<Pair<String, FieldType>>
) {
    // 描述符输出到流
    fun writeTo(stream: OutputStream) {
        stream.writeEnd(name)
        for ((name, type) in fields) {
            stream.writeEnd(name)
            stream.write(type.id)
        }
        stream.write(0)
    }

    override fun equals(other: Any?) = (other as? StructDescription)?.name == name
    override fun hashCode() = name.hashCode()

    companion object {
        fun readFrom(stream: InputStream) =
            StructDescription(
                stream.readEnd(),
                generateSequence {
                    stream
                        .readEnd()
                        .takeIf(String::isNotBlank)
                        ?.let { sub -> sub to FieldType.values().first { it.id == stream.read() } }
                }.toList()
            )
    }
}