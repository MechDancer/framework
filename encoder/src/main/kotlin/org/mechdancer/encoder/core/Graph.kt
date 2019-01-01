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

    /** 构造包含[root]的连通子图 */
    fun subWith(root: Node) =
        mutableMapOf<Node, Iterable<Path>>()
            .also { lock.read { root.addTo(it) } }
            .let { Graph(it, selector) }

    /**
     * 从[root]开始（反）拓扑排序
     * @return 连通的、可顺序构造的节点列表
     */
    fun sort(root: Node) =
        mutableListOf(root)
            .also { sub ->
                // 剩余项
                val rest = core.keys.toMutableSet().apply { remove(root) }
                // 已接纳指针
                var ptr = 0
                // 若仍有未连通的
                while (rest.isNotEmpty())
                // 已连通的全部检查过，直接返回
                // 否则尝试从邻接表中获取
                    get(sub.getOrNull(ptr++) ?: break)
                        // 找到所有连接到的节点
                        ?.map(selector)
                        ?.toMutableSet()
                        // 取其中非叶子但未连接的
                        ?.apply { retainAll(rest) }
                        // 从未连接的移除，添加到已连接的
                        ?.also {
                            rest.removeAll(it)
                            sub.addAll(it)
                        }
            }

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