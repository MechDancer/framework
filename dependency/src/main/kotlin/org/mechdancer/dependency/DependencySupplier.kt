package org.mechdancer.dependency

import org.mechdancer.dependency.named.NamedDependencyManager
import org.mechdancer.dependency.unique.UniqueDependencyManager

interface DependencySupplier<T : DependencyManager> {
    val manager: T

    fun sync(dependency: Component): Boolean
}

class DependencySupplierImpl<T : DependencyManager>(override val manager: T) : DependencySupplier<T> {
    override fun sync(dependency: Component): Boolean = manager.sync(dependency)
}

fun namedDependencyManager() = DependencySupplierImpl(NamedDependencyManager())
fun uniqueDependencyManager() = DependencySupplierImpl(UniqueDependencyManager())