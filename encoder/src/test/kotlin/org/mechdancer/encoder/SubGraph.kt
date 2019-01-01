package org.mechdancer.encoder

import org.junit.Assert
import org.junit.Test
import org.mechdancer.encoder.core.Graph

class SubGraph {
    @Test
    fun test() {
        val graph = Graph(
            mapOf(
                "A" to listOf("B", "C"),
                "B" to listOf("D"),
                "D" to listOf("E"),
                "E" to listOf("A", "B", "C")
            )
        ) { it }
        Assert.assertEquals(listOf("B", "D", "E", "A"), graph.sort("B"))
    }
}
