package org.mechdancer.dependency.named

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.firstGenericType
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

abstract class NamedComponent<T : NamedComponent<T>>
    (val name: String, type: KClass<T>? = null) : Component {

    @Suppress("UNCHECKED_CAST")
    val type = type ?: javaClass.kotlin.firstGenericType(NamedComponent::class) as KClass<T>

    override fun equals(other: Any?) =
        this === other || type.safeCast(other)?.name == name

    override fun hashCode() =
        (type.hashCode() shl 31) + name.hashCode()
}
