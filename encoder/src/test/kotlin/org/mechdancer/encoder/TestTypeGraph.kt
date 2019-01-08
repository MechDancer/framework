package org.mechdancer.encoder

import org.junit.Assert
import org.junit.Test
import org.mechdancer.encoder.core.data.Basic
import org.mechdancer.encoder.core.type.Field
import org.mechdancer.encoder.core.type.Property
import org.mechdancer.encoder.core.type.TypeGraph
import org.mechdancer.encoder.serialization.util.toTypeGraph
import org.mechdancer.encoder.serialization.util.view

class Pen {
    val length = 0
}

class Apple(
    val size: Int,
    val color: String
) {

    private val pen = Pen()

    private val array = intArrayOf(2, 3, 3)

}

class TestTypeGraph {
    @Test
    fun test() {
        val expected = TypeGraph(
            mapOf(
                "Apple" to listOf(
                    Field("size", Basic.I4.name, Property.Unit),
                    Field("color", Basic.S.name, Property.Unit),
                    Field("array", Basic.I4.name, Property.Array),
                    Field("pen", "Pen", Property.Unit)
                ),
                "Pen" to listOf(
                    Field("length", Basic.I4.name, Property.Unit)
                )
            )
        )
        val actual = Apple::class.toTypeGraph()
        Assert.assertEquals(expected.view(Apple::class).toSet(), actual.view(Apple::class).toSet())
        Assert.assertEquals(expected.view(Pen::class).toSet(), actual.view(Pen::class).toSet())
    }
}
