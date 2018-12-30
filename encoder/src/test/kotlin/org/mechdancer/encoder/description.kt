package org.mechdancer.encoder

import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    val struct = StructMonitor()
    for (value in BasicStruct.values()) {
        struct.add(value.encode)
    }

    struct.add(
        StructDescription(
            "vector2D",
            listOf("f8" to FieldType.Unit, "f8" to FieldType.Unit)
        )
    )

    struct
        .buildDescription("vector2D")
        .also { println(it.joinToString(" ")) }
        .let { struct.analysis(ByteArrayInputStream(it)) }
        .let { (topic, bytes) -> println("$topic: byte[${bytes.size}]") }
}