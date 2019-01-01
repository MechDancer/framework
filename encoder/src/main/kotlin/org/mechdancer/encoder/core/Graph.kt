package org.mechdancer.encoder.core

import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

/**
 * 稀疏有向图/出路邻接表
 *
 * 算法的正确性依赖于开发者保证图的封闭性
 * 即所有出度>0的节点在图中
 *
 * @param Node 节点
 * @param Path 路径
 * @param Core 表结构
 */
open class Graph<
    Node : Any,
    Path : Any,
    Core : Map<Node, Iterable<Path>>>(
    private val core: Core,
    private val selector: (Path) -> Node
) : Map<Node, Iterable<Path>> by core {
    private val lock = ReentrantReadWriteLock()

    /** 安全操作表结构 */
    operator fun invoke(block: Core.() -> Unit) =
        lock.write { block(core) }

    /** 构造包含[key]的连通子图 */
    fun subWith(key: Node) =
        mutableMapOf<Node, Iterable<Path>>()
            .also { lock.read { key.addTo(it) } }
            .let { Graph(it, selector) }

    // 递归构造连通子图
    private fun Node.addTo(map: MutableMap<Node, Iterable<Path>>) {
        if (map.size < size) // 仍有节点未加入
            get(this)        // 当前节点出路
                ?.takeIf(Iterable<*>::any)                     // 不是叶子
                ?.takeIf { map.putIfAbsent(this, it) == null } // 之前不存在
                ?.map(selector)                                //
                ?.forEach { it.addTo(map) }                    // 递归
    }
}