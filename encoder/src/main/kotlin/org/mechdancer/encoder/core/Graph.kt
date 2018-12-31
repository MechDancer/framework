package org.mechdancer.encoder.core

import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

/**
 * 稀疏图/邻接表
 *
 * 算法的正确性依赖于开发者保证图的封闭性
 * 即所有出度>0的节点在图中
 *
 * @param Node 节点主键类型
 * @param Node 节点完全类型
 * @param Core 表结构
 */
open class Graph<
    Key : Any,
    Node : Any,
    Core : Map<Key, Iterable<Node>>>(
    private val core: Core,
    private val selector: (Node) -> Key
) : Map<Key, Iterable<Node>> by core {
    private val lock = ReentrantReadWriteLock()

    /** 安全操作表结构 */
    fun operate(block: Core.() -> Unit) =
        lock.write { block(core) }

    /** 构造包含[key]的连通子图 */
    fun subWith(key: Key) =
        mutableMapOf<Key, Iterable<Node>>()
            .also { lock.read { key.addTo(it) } }
            .let { Graph(it, selector) }

    /** 构造包含[key]的连通子图 */
    fun subWith1(key: Key) =
        mutableMapOf<Key, Iterable<Node>>()
            .also { lock.read { key.addTo(it) } }
            .let { it.remove(key)!! to it }
            .let { (root, tail) -> root to Graph(tail, selector) }

    // 递归构造连通子图
    private fun Key.addTo(map: MutableMap<Key, Iterable<Node>>) {
        (core[this] ?: listOf())
            .takeIf { map.putIfAbsent(this, it) == null }
            ?.map(selector)
            ?.forEach { it.addTo(map) }
    }
}