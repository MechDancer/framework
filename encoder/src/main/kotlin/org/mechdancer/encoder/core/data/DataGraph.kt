package org.mechdancer.encoder.core.data

import org.mechdancer.encoder.core.Graph
import org.mechdancer.encoder.core.data.BasicCoder.Companion.Decoders
import org.mechdancer.encoder.core.data.BasicCoder.Companion.Encoders
import org.mechdancer.encoder.core.data.BasicCoder.Uv
import org.mechdancer.encoder.core.extract
import org.mechdancer.encoder.core.simplify
import org.mechdancer.encoder.core.type.Field
import org.mechdancer.encoder.core.type.Property
import org.mechdancer.encoder.util.buildByteArray
import org.mechdancer.encoder.util.zigzag
import java.io.InputStream
import java.io.OutputStream

/**
 * 引用关系图
 * total: { size: uv, data: +(item) }
 * item:  { fields: +(i: uv, data: basic? bytes : reference index), 0 }
 *
 * @param struct 根据类型查找结构
 */
class DataGraph<T : Map<Data, Iterable<FieldData>>>(
    core: T,
    private val struct: (String) -> Iterable<Field>
) : Graph<Data, FieldData, T>(core, FieldData::data) {

    /** 从[root]出发进行序列化 */
    fun serialize(root: Data) {
        val (head, tail) = extract(root)

        val references = tail.simplify()
        val index =
            references
                .keys
                .mapIndexed { i, data -> data.value?.let { it to i } }
                .filterNotNull()
                .toMap()

        buildByteArray {
            zigzag(tail.size + 1L, false)
            writeData(index, head.second!!, struct(head.first.type))
            for (reference in references)
                writeData(index, reference.value, struct(reference.key.type))
        }
    }

    companion object {

        fun deserialize(
            stream: InputStream,
            rootType: String,
            struct: (String) -> Iterable<Field>
        ) {
            val count = stream.zigzag(false).toInt() - 1
            val graph = DataGraph(mutableMapOf(), struct)
            val root = stream.readData(struct(rootType).toList())
            graph {
                this[Data(rootType, root)] = root
            }
            root.asSequence()
                .filter { it.data.type !in BasicCoder }
                .associate { (it.data.value as Long).toInt() to it.data.type }
        }

        // 生成引用编码器
        private fun pointerWriter(map: Map<Any, Int>) =
            { stream: OutputStream, it: Any ->
                stream.zigzag(map[it]!!.toLong(), false)
            }

        // 向流中写入一个数据项
        private fun OutputStream.writeData(
            index: Map<Any, Int>,           // 引用项序号
            fieldData: Iterable<FieldData>, // 此项的字段
            struct: Iterable<Field>         // 此项的结构
        ) {
            // 字段表生成映射关系，方便与结构按名字对应
            val dataMap = fieldData.associate { it.name to it.data.value }
            // 结构与字段表按名字对应
            // 字段不存在或字段的值不存在则跳过
            val fields = struct
                .mapIndexed { i, field ->
                    dataMap[field.name]?.let { Triple(field, i, it) }
                }
                .filterNotNull()
            // 遍历字段并写入
            for ((info, i, data) in fields) {
                // 写入序号
                zigzag(i + 1L, false)
                // 生成编码器
                val encoder = Encoders[info.type] ?: pointerWriter(index)
                // 编码
                when (info.property) {
                    // 编码单体
                    Property.Unit,
                    Property.Nullable -> encoder(this, data)
                    // 编码数组
                    Property.Array    -> {
                        val array = when (data) {
                            is Iterable<*> -> data.toList()
                            is Array<*>    -> data.toList()
                            is Sequence<*> -> data.toList()
                            else           -> throw IllegalArgumentException("not a collection type")
                        }.filterNotNull()
                        zigzag(array.size.toLong(), false)
                        for (item in array) encoder(this, item)
                    }
                }
            }
            write(0)
        }

        // 从流中读取一个数据项
        private fun InputStream.readData(struct: List<Field>) =
            generateSequence {
                zigzag(false)
                    .takeIf { it > 0 }
                    ?.let { it.toInt() - 1 }
                    ?.let(struct::get)
                    ?.let { (name, type, property) ->
                        val decoder = Decoders[type] ?: Uv.decoder
                        FieldData(name, type, when (property) {
                            Property.Unit,
                            Property.Nullable -> decoder(this)
                            Property.Array    -> List(zigzag(false).toInt()) { decoder(this) }
                        })
                    }
            }.toList()
    }
}