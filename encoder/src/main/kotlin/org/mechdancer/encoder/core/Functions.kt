package org.mechdancer.encoder.core

/** 安全获取表项 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.getOrEmpty(node: Node) =
    getOrDefault(node, listOf())

/** 获取节点的字符串表示 */
fun <Node : Any, Path : Any>
    Map<Node, Iterable<Path>>.view(node: Node) =
    "$node: ${getOrEmpty(node)}"
