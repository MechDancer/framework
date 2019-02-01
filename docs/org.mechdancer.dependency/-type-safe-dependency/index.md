---
title: TypeSafeDependency - 
---

[org.mechdancer.dependency](../index.html) / [TypeSafeDependency](./index.html)

# TypeSafeDependency

`sealed class TypeSafeDependency<T : `[`Component`](../-component/index.html)`>`

依赖项

具体到类型 [T](index.html#T) 并依类型判别冲突
保存到组件实例的引用
线程安全

### Types

| [Dependency](-dependency/index.html) | `class Dependency<T : `[`Component`](../-component/index.html)`> : `[`TypeSafeDependency`](./index.html)`<`[`T`](-dependency/index.html#T)`>`<br>类型 [T](-dependency/index.html#T) 的强依赖项 |
| [WeakDependency](-weak-dependency/index.html) | `class WeakDependency<T : `[`Component`](../-component/index.html)`> : `[`TypeSafeDependency`](./index.html)`<`[`T`](-weak-dependency/index.html#T)`>`<br>类型 [T](-weak-dependency/index.html#T) 的弱依赖项 |

### Properties

| [field](field.html) | `open val field: `[`T`](index.html#T)`?`<br>尝试获取值 |
| [type](type.html) | `val type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`T`](index.html#T)`>` |

### Functions

| [equals](equals.html) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.html) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [set](set.html) | `fun set(value: `[`Component`](../-component/index.html)`): `[`T`](index.html#T)`?`<br>尝试置入值 [value](set.html#org.mechdancer.dependency.TypeSafeDependency$set(org.mechdancer.dependency.Component)/value)，若无法转换到目标类型则不产生作用 |

### Inheritors

| [Dependency](-dependency/index.html) | `class Dependency<T : `[`Component`](../-component/index.html)`> : `[`TypeSafeDependency`](./index.html)`<`[`T`](-dependency/index.html#T)`>`<br>类型 [T](-dependency/index.html#T) 的强依赖项 |
| [WeakDependency](-weak-dependency/index.html) | `class WeakDependency<T : `[`Component`](../-component/index.html)`> : `[`TypeSafeDependency`](./index.html)`<`[`T`](-weak-dependency/index.html#T)`>`<br>类型 [T](-weak-dependency/index.html#T) 的弱依赖项 |

