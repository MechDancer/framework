package org.mechdancer.encoder.core

/** 提出图中的一项 */
fun <Key : Any, Node : Any>
    Map<Key, Iterable<Node>>.extract(key: Key) =
    toMutableMap().let { key to it.remove(key) to it }

/** 获取节点的字符串表示 */
fun <Key : Any, Node : Any>
    Map<Key, Iterable<Node>>.view(type: Key) =
    "$type: ${this[type] ?: listOf()}"

/** 化简 */
fun <Key : Any, Node : Any>
    Map<Key, Iterable<Node>>.simplify() =
    filterValues { it.firstOrNull() != null }
