package org.mechdancer.encoder.core

/**
 * 用引用描述邻接表的图
 */
class ReferenceGraph<Node : Any, Path : Any>(
    map: Map<Node, Iterable<Path>>
) {
    val nodes: Map<Node, Int>
    val paths: List<Iterable<Path>>

    init {
        val list = map.keys.toList()

        nodes = list.mapIndexed { i, node -> node to i }.toMap()
        paths = List(list.size) { i -> map[list[i]]!! }
    }
}