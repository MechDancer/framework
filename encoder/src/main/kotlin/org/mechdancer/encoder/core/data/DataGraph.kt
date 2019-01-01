package org.mechdancer.encoder.core.data

import org.mechdancer.encoder.core.Graph
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
 * 必须本身是连通图
 *
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
    fun serialize(root: Data): ByteArray {
        val (head, tail) = extract(root)
        val references = tail.simplify()

        return buildByteArray {
            zigzag(tail.size + 1L, false)
            writeData(head.second!!, struct(head.first.type))
            for (reference in references)
                writeData(reference.value, struct(reference.key.type))
        }
    }

    companion object {
        /**
         * 从邻接表构造引用关系图
         * 其实是自动分配了指针
         *
         * @param data   邻接表 { name: String, fields: +(field data) }
         * @param struct 结构描述表
         */
        operator fun invoke(
            vararg data: Pair<String, Iterable<FieldData>>,
            struct: (String) -> Iterable<Field>
        ) = DataGraph(
            data.mapIndexed { i, (type, fields) -> Data(type, i) to fields }
                .toMap(),
            struct
        )

        /**
         * 从输入流[stream]反序列化
         * 已知序号0的引用类型为[root]
         * 所有已知类型的结构描述通过[struct]查询
         */
        fun deserialize(
            stream: InputStream,
            root: String,
            struct: (String) -> Iterable<Field>
        ): DataGraph<*> {
            val types = arrayOfNulls<String>(stream.zigzag(false).toInt())
            types[0] = root

            return types
                .indices
                .asSequence()
                .associate { i ->
                    val type = types[i]!!
                    val fields = stream.readData(struct(type).toList())
                    fields
                        .asSequence()
                        .filter { it.data.type !in Basic }
                        .map(FieldData::data)
                        .forEach { (type, i) -> types[i as Int] = type }
                    Data(type, i) to fields
                }
                .let { DataGraph(it, struct) }
        }

        // 向流中写入一个数据项
        private fun OutputStream.writeData(
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
                val encoder = Basic.encoder(info.type)
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
                        val decoder = Basic.decoder(type)
                        FieldData(name, type, when (property) {
                            Property.Unit,
                            Property.Nullable -> decoder(this)
                            Property.Array    -> List(zigzag(false).toInt()) { decoder(this) }
                        })
                    }
            }.toList()
    }
}