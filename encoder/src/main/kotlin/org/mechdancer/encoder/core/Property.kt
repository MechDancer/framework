package org.mechdancer.encoder.core

/**
 * 字段类型
 * @param id 标记类型的字节
 */
enum class Property(val id: Int, val sign: String) {
    Unit(1, ""), Nullable(2, "?"), Array(3, "...");

    companion object {
        val map = values().associate { it.id to it }
    }
}