package org.mechdancer.encoder.core

/** 获取节点的字符串表示 */
fun <Key : Any, Node : Any>
    Graph<Key, Node, out Map<Key, Iterable<Node>>>.view(type: Key) =
    "$type: ${this[type] ?: listOf()}"