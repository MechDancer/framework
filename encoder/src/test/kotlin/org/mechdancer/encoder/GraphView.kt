package org.mechdancer.encoder

import org.mechdancer.encoder.core.view

fun main(args: Array<String>) {
    types.view("double").let(::println)
    types.view("vector").let(::println)
    types.view("vector2D").let(::println)
}