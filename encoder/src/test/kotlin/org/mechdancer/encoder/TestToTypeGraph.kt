package org.mechdancer.encoder

import org.mechdancer.encoder.serialization.annotation.Skip
import org.mechdancer.encoder.serialization.util.toTypeGraph
import org.mechdancer.encoder.serialization.util.view
import kotlin.system.measureNanoTime

class Pen {
    val length = 0
}

class Apple(
    val size: Int,
    val color: String
) {
    @Skip
    private val pen = Pen()


    @Skip
    val array = intArrayOf(2, 3, 3)

}


fun main() {
    println(measureNanoTime {
        val t = Apple::class.toTypeGraph()
        println(t.view(Apple::class))
        println(t.view(Pen::class))
    } * 1E-9)
}
