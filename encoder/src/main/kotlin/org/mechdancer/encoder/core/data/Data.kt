package org.mechdancer.encoder.core.data

/**
 * 数据描述
 * @param type  名字
 * @param value 值类型? 值 : 指针
 */
data class Data(val type: String, val value: Any?) {
    override fun toString() =
        "($type) ${if (type !in Basic) "[$value]" else value.toString()}"
}