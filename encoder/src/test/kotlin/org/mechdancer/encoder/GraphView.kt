package org.mechdancer.encoder

import org.mechdancer.encoder.core.Field
import org.mechdancer.encoder.core.Property
import org.mechdancer.encoder.core.view

fun main(args: Array<String>) {
    val types = TypeGraph(
        mapOf(
            "vector" to setOf(
                Field("data", "double", Property.Array)
            ),
            "vector2D" to setOf(
                Field("x", "double", Property.Unit),
                Field("y", "double", Property.Unit)
            )
        )
    )
    types.view("vector").let(::println)
    types.view("vector2D").let(::println)
}