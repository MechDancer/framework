package org.mechdancer.encoder.core.data

/**
 * 数据描述
 * @param type  名字
 * @param value 值
 */
data class Data(val type: String, val value: Any?) {
    override fun toString() = "($type) $value"
}