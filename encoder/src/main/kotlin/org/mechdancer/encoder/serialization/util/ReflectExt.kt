package org.mechdancer.encoder.serialization.util

import org.mechdancer.encoder.core.type.Field
import org.mechdancer.encoder.core.type.Property
import org.mechdancer.encoder.core.type.TypeGraph
import org.mechdancer.encoder.serialization.annotation.Skip
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.jvmErasure

private val basics = mapOf(
    Byte::class to "I1",
    Short::class to "I2",
    Int::class to "I3",
    Long::class to "I8",
    Float::class to "F4",
    String::class to "S"
)

fun KProperty<*>.isBasicType() = basics.containsKey(this.returnType.jvmErasure)

fun KProperty<*>.isArray() =
    returnType.jvmErasure.java.componentType != null

fun KType.toBasicTypeName() = basics[jvmErasure] ?: basics[jvmErasure.java.componentType?.kotlin]

fun KProperty<*>.isBasicTypeArray() =
    isArray() && basics.containsKey(returnType.jvmErasure)

fun KClass<*>.findAllProperties(exclude: Set<String> = setOf("kotlin.", "java.")): List<KProperty<*>> {
    fun KProperty<*>.flatten(): List<KProperty<*>> =
        returnType.jvmErasure.declaredMemberProperties.fold(mutableListOf(this)) { acc, field ->
            if (field.instanceParameter?.type?.jvmErasure?.qualifiedName?.let { name ->
                    exclude.map { name.contains(it) }.any { it }
                } == true) {
            } else if (field.isBasicType() || field.isBasicTypeArray())
                acc.add(field)
            else acc.addAll(field.flatten())

            acc
        }

    return declaredMemberProperties.flatMap { it.flatten() }
}


fun KClass<*>.toTypeGraph(): TypeGraph<Map<String, List<Field>>> {

    val description = mutableMapOf<String, MutableList<Field>>()

    val nonBasic = mutableListOf<KProperty<*>>()

    description[qualifiedName!!] = ArrayList(declaredMemberProperties.filterNot {
        it.findAnnotation<Skip>() != null
    }.map {
        Field(
            it.name,
            it.returnType.toBasicTypeName() ?: it.returnType.jvmErasure.qualifiedName!!.apply { nonBasic.add(it) },
            if (it.isArray()) Property.Array else Property.Unit
        )
    })

    fun processNonBasic(c: List<KProperty<*>>) {
        val cache = mutableListOf<KProperty<*>>()
        c.forEach { p ->
            description[p.returnType.jvmErasure.qualifiedName!!] =
                    ArrayList(p.returnType.jvmErasure.declaredMemberProperties.filter {
                        it.findAnnotation<Skip>() == null
                    }.map {
                        Field(
                            it.name,
                            it.returnType.toBasicTypeName()
                                ?: it.returnType.jvmErasure.qualifiedName!!.apply { cache.add(it) },
                            if (it.isArray()) Property.Array else Property.Unit
                        )
                    })

        }
        if (cache.isNotEmpty())
            processNonBasic(cache)
    }
    processNonBasic(nonBasic)
    return TypeGraph(description)
}