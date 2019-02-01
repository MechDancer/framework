---
title: TypeSafeDependency.WeakDependency - 
---

[org.mechdancer.dependency](../../index.html) / [TypeSafeDependency](../index.html) / [WeakDependency](./index.html)

# WeakDependency

`class WeakDependency<T : `[`Component`](../../-component/index.html)`> : `[`TypeSafeDependency`](../index.html)`<`[`T`](index.html#T)`>`

类型 [T](index.html#T) 的弱依赖项

### Constructors

| [&lt;init&gt;](-init-.html) | `WeakDependency(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`T`](index.html#T)`>, predicate: (`[`T`](index.html#T)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>类型 [T](index.html#T) 的弱依赖项 |

### Inherited Properties

| [field](../field.html) | `open val field: `[`T`](../index.html#T)`?`<br>尝试获取值 |
| [type](../type.html) | `val type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`T`](../index.html#T)`>` |

### Inherited Functions

| [equals](../equals.html) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../hash-code.html) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [set](../set.html) | `fun set(value: `[`Component`](../../-component/index.html)`): `[`T`](../index.html#T)`?`<br>尝试置入值 [value](../set.html#org.mechdancer.dependency.TypeSafeDependency$set(org.mechdancer.dependency.Component)/value)，若无法转换到目标类型则不产生作用 |
