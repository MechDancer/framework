package org.mechdancer.dependency.named

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.firstGenericType
import org.mechdancer.dependency.unique.UniqueComponent
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

abstract class NamedComponent<T : NamedComponent<T>>
    (val name: String, type: KClass<T>? = null) : Component {

    val type: KClass<T> =
        type ?: javaClass.kotlin.firstGenericType(UniqueComponent::class) as KClass<T>

    override fun equals(other: Any?) =
        this === other || type.safeCast(other)?.name == name

    override fun hashCode() =
        (type.hashCode() shl 31) + name.hashCode()
}
