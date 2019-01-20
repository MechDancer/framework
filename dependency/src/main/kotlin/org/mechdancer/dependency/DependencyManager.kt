package org.mechdancer.dependency

/**
 * 依赖管理器
 *
 * 可直接
 */
interface DependencyManager {

    /**
     * 扫描依赖
     */
    fun sync(dependency: Component): Boolean

}