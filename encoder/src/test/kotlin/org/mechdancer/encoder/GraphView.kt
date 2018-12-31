package org.mechdancer.encoder

import org.mechdancer.encoder.core.type.Field
import org.mechdancer.encoder.core.type.Property
import org.mechdancer.encoder.core.type.TypeGraph
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

    types.view("double").let(::println)
    types.view("vector").let(::println)
    types.view("vector2D").let(::println)
}