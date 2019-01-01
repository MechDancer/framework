package org.mechdancer.encoder

import org.mechdancer.encoder.core.data.Basic
import org.mechdancer.encoder.core.data.Data
import org.mechdancer.encoder.core.data.DataGraph
import org.mechdancer.encoder.core.data.FieldData
import java.io.ByteArrayInputStream

fun main() {
    val graph = DataGraph(
        "pose" to setOf(
            FieldData("location", "vector2D", 1),
            FieldData("direction", Basic.F8.name, 2.0)
        ),
        "vector2D" to setOf(
            FieldData("x", Basic.F8.name, 1.2),
            FieldData("y", Basic.F8.name, 3.4)
        )
    ) { types[it]!! }

    println()
    graph.serialize(Data("pose", 0))
        .also {
            println("bytes[${it.size}]:")
            println(it.joinToString(" "))
            println()
        }
        .let(::ByteArrayInputStream)
        .let { DataGraph.deserialize(it, "pose") { types[it]!! } }
        .also { println("solve:") }
        .forEach(::println)
}