package org.mechdancer.encoder

/**
 * 字段类型
 * @param id 标记类型的字节
 */
enum class FieldType(val id: Int) {
    Unit(1), Array(2);

    companion object {
        val map = values().associate { it.id to it }
    }
}