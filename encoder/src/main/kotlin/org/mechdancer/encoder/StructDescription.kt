package org.mechdancer.encoder

/**
 * 结构描述符
 */
data class StructDescription(
    val name: String,
    val fields: List<Pair<String, FieldType>>
) {
    override fun equals(other: Any?) = (other as? StructDescription)?.name == name
    override fun hashCode() = name.hashCode()
}