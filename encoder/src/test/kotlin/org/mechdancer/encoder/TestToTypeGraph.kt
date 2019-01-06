package org.mechdancer.encoder

import org.mechdancer.encoder.serialization.annotation.Delegatee
import org.mechdancer.encoder.serialization.annotation.Skip
import org.mechdancer.encoder.serialization.util.toTypeGraph
import org.mechdancer.encoder.serialization.util.view
import kotlin.system.measureNanoTime

class Pen {
    val length = 0
}

class Apple {

    constructor(size: Int, color: String) {
        this.size = size
        this.color = color
    }

    constructor(serialization: MutableMap<String, Any?>) {
        this.serialization.putAll(serialization)
    }

    @Delegatee
    private val serialization = mutableMapOf<String, Any?>()

    @Skip
    private val pen = Pen()

    var size: Int by serialization

    @Skip
    val array = intArrayOf(2, 3, 3)

    var color: String by serialization
}


fun main() {
    println(measureNanoTime {
        val t = Apple::class.toTypeGraph()
        println(t.view(Apple::class))
        println(t.view(Pen::class))
    } * 1E-9)
}
