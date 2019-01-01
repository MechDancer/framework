package org.mechdancer.encoder.core

/** 安全获取表项 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.getOrEmpty(node: Node) =
    getOrDefault(node, listOf())

/** 提出图中的一项 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.extract(node: Node) =
    toMutableMap().let { node to it.remove(node) to it }

/** 获取节点的字符串表示 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.view(node: Node) =
    "$node: ${getOrEmpty(node)}"

/** 化简 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.simplify() =
    filterValues(Iterable<*>::any)

/** 用指针压缩标准图 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.compress() =
    ReferenceGraph(this)