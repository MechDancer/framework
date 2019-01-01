package org.mechdancer.encoder

import org.mechdancer.encoder.core.type.TypeGraph
import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    for (it in types.keys) test(types, it)
}

fun test(graph: TypeGraph<*>, type: String) {
    graph
        .serialize(type)
        .also { println(it.joinToString(" ")) }
        .let { TypeGraph.deserialize(ByteArrayInputStream(it)) }
        .forEach { (name, fields) -> println("$name: $fields") }
        .also { println() }
}