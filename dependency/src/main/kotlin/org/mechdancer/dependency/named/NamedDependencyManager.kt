package org.mechdancer.dependency.named

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.Dependent
import org.mechdancer.dependency.TypeSafeDependency
import org.mechdancer.dependency.TypeSafeDependency.Dependency
import org.mechdancer.dependency.TypeSafeDependency.WeakDependency
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * 以类型区分的依赖项管理
 *
 * 应聚合到 `Dependent` 内部
 */
class NamedDependencyManager {
    // 尚未装载的依赖项集
    private val dependencies = hashSetOf<Stub<*>>()

    // 添加依赖项到集合，发生冲突时产生异常
    private fun <T : Component> add(name: String, dependency: TypeSafeDependency<T>, type: KClass<T>) =
        synchronized(dependencies) {
            if (dependencies.add(Stub(name, dependency)))
                throw RuntimeException("try to add the second ${type.qualifiedName}")
        }

    /** 每一次扫描都清除成功装载的依赖项 */
    fun sync(dependency: Component) =
        synchronized(dependencies) {
            val maybe = dependency as? NamedComponent<*> ?: return dependencies.isEmpty()
            dependencies.removeIf { it.name == maybe.name && it.dependency.set(maybe) != null }
            && dependencies.isEmpty()
        }

    /** 构造一个 [C] 类型的强依赖 */
    fun <C : Component> dependOnStrict(name: String, type: KClass<C>) =
        Dependency(type).also { add(name, it, type) }

    /** 构造一个 [C] 类型的弱依赖 */
    fun <C : Component> dependOnWeak(name: String, type: KClass<C>) =
        WeakDependency(type).also { add(name, it, type) }

    /** 构造一个 [C] 类型的强依赖 */
    inline fun <reified C : Component> dependency(name: String) = dependOnStrict(name, C::class)

    /** 构造一个 [C] 类型的弱依赖 */
    inline fun <reified C : Component> weakDependency(name: String) = dependOnWeak(name, C::class)

    /** 从一个 [C] 类型的强依赖取值 */
    inline fun <reified C : Component, T> must(name: String, crossinline block: (C) -> T): Lazy<T> {
        val dependency = dependency<C>(name)
        return lazy { dependency.field.let(block) }
    }

    /** 从一个 [C] 类型的弱依赖取值 */
    inline fun <reified C : Component, T> maybe(name: String, default: T, crossinline block: (C) -> T): Lazy<T> {
        val dependency = weakDependency<C>(name)
        return lazy { dependency.field?.let(block) ?: default }
    }

    /** 构造一个 [C] 类型的强依赖属性代理 */
    inline fun <reified C : Component> must(name: String) =
        object : ReadOnlyProperty<Dependent, C> {
            private val core = dependency<C>(name)
            override fun getValue(thisRef: Dependent, property: KProperty<*>) = core.field
        }

    /** 构造一个 [C] 类型的弱依赖属性代理 */
    inline fun <reified C : Component> maybe(name: String) =
        object : ReadOnlyProperty<Dependent, C?> {
            private val core = weakDependency<C>(name)
            override fun getValue(thisRef: Dependent, property: KProperty<*>) = core.field
        }

    private data class Stub<T : Component>(val name: String, val dependency: TypeSafeDependency<T>)
}
