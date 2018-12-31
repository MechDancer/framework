package org.mechdancer.encoder.core

/** 提出图中的一项 */
fun <Key : Any, Node : Any>
    Graph<Key, Node, out Map<Key, Iterable<Node>>>.take(key: Key) =
    toMutableMap().let { key to it.remove(key) to it }
