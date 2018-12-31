package org.mechdancer.encoder.core

/**
 * 字段
 * @param name     名字
 * @param type     类型名字
 * @param property 性质
 */
data class Field(val name: String, val type: String, val property: Property) {
    override fun equals(other: Any?) = (other as? Field)?.name == name
    override fun hashCode() = name.hashCode()
    override fun toString() = "$name: $type${property.sign}"
}