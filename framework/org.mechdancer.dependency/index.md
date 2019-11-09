---
title: org.mechdancer.dependency - framework
---

[framework](../index.html) / [org.mechdancer.dependency](./index.html)

## Package org.mechdancer.dependency

### Types

| [Component](-component/index.html) | 组件`interface Component` |
| [DependencyManager](-dependency-manager/index.html) | 典型依赖管理器`class DependencyManager` |
| [Dependent](-dependent/index.html) | 依赖者`interface Dependent : `[`Component`](-component/index.html) |
| [DynamicScope](-dynamic-scope/index.html) | 动态域`open class DynamicScope` |
| [NamedComponent](-named-component/index.html) | 具名组件`abstract class NamedComponent<T : `[`NamedComponent`](-named-component/index.html)`<T>> : `[`Component`](-component/index.html) |
| [TypeSafeDependency](-type-safe-dependency/index.html) | 依赖项`sealed class TypeSafeDependency<T : `[`Component`](-component/index.html)`>` |
| [UniqueComponent](-unique-component/index.html) | 唯一组件`abstract class UniqueComponent<T : `[`UniqueComponent`](-unique-component/index.html)`<T>> : `[`Component`](-component/index.html) |

### Exceptions

| [ComponentNotExistException](-component-not-exist-exception/index.html) | 组件不存在异常`class ComponentNotExistException : `[`RuntimeException`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html) |

### Extensions for External Classes

| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.html) |  |
| [kotlin.reflect.KClass](kotlin.reflect.-k-class/index.html) |  |

### Functions

| [buildView](build-view.html) | 构造映射浏览器`fun <T, U> buildView(map: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<T, U>): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<T, U>` |
| [dependency](dependency.html) | 构造一个 [C](dependency.html#C) 类型的强依赖`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependency(): Dependency<C>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependency(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Dependency<C>` |
| [dependOnStrict](depend-on-strict.html) | 构造一个 [C](depend-on-strict.html#C) 类型的强依赖`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>): Dependency<C>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Dependency<C>` |
| [dependOnWeak](depend-on-weak.html) | 构造一个 [C](depend-on-weak.html#C) 类型的弱依赖`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>): WeakDependency<C>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): WeakDependency<C>` |
| [maybe](maybe.html) | 从一个 [C](maybe.html#C) 类型的弱依赖取值`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(default: T, block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, default: T, block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>`<br>构造一个 [C](maybe.html#C) 类型的弱依赖属性代理`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C?>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C?>` |
| [must](must.html) | 构造一个 [C](must.html#C) 类型的强依赖属性代理`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.must(): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.must(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C>` |
| [mustNamed](must-named.html) | 从一个 [C](must-named.html#C) 类型的强依赖取值`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.mustNamed(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>` |
| [mustUnique](must-unique.html) | 从一个 [C](must-unique.html#C) 类型的强依赖取值`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.mustUnique(block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>` |
| [plusAssign](plus-assign.html) | 向动态域添加新的依赖项`operator fun `[`DynamicScope`](-dynamic-scope/index.html)`.plusAssign(component: `[`Component`](-component/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [scope](scope.html) | 构造动态域`fun scope(block: `[`DynamicScope`](-dynamic-scope/index.html)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`DynamicScope`](-dynamic-scope/index.html) |
| [setup](setup.html) | 向动态域添加并执行一个操作`fun <T : `[`Component`](-component/index.html)`> `[`DynamicScope`](-dynamic-scope/index.html)`.setup(component: T, block: T.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [weakDependency](weak-dependency.html) | 构造一个 [C](weak-dependency.html#C) 类型的弱依赖`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.weakDependency(): WeakDependency<C>`<br>`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.weakDependency(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): WeakDependency<C>` |

