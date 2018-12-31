package org.mechdancer.encoder.core.data

/**
 * 数据描述
 * @param name  名字
 * @param type  类型名字
 * @param value 值
 */
data class Data(
    val name: String,
    val type: String,
    val value: Any
) {
    override fun equals(other: Any?) = (other as? Data)?.value == value
    override fun hashCode() = name.hashCode()
    override fun toString() = "$name: $type = $value"
}