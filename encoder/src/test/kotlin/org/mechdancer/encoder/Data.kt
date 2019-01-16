package org.mechdancer.encoder

import org.mechdancer.encoder.core.data.Basic
import org.mechdancer.encoder.core.data.Data
import org.mechdancer.encoder.core.data.DataGraph
import org.mechdancer.encoder.core.data.FieldData
import org.mechdancer.encoder.core.getOrEmpty
import java.io.ByteArrayInputStream

fun main() {
    val root = "pose"
    val graph = DataGraph.create(
        root to setOf(
            FieldData("location", "vector2D", 1),
            FieldData("direction", Basic.F8.name, 2.0)
        ),
        "vector2D" to setOf(
            FieldData("x", Basic.F8.name, 1.2),
            FieldData("y", Basic.F8.name, 3.4)
        ),
        struct = types::getOrEmpty
    )

    println()
    graph.serialize(Data(root, 0))
        .also {
            println("bytes[${it.size}]:")
            println(it.joinToString(" "))
            println()
        }
        .let(::ByteArrayInputStream)
        .let { bytes -> DataGraph.deserialize(bytes, root, types::getOrEmpty) }
        .also { println("solve:") }
        .forEach(::println)
}