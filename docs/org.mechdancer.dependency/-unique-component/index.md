---
title: UniqueComponent - 
---

[org.mechdancer.dependency](../index.html) / [UniqueComponent](./index.html)

# UniqueComponent

`abstract class UniqueComponent<T : `[`UniqueComponent`](./index.html)`<`[`T`](index.html#T)`>> : `[`Component`](../-component/index.html)

唯一组件

同类型的组件不能共存

### Constructors

| [&lt;init&gt;](-init-.html) | `UniqueComponent(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`T`](index.html#T)`>? = null)`<br>唯一组件 |

### Properties

| [type](type.html) | `val type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |

### Functions

| [equals](equals.html) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>判断能否与[other](../-component/equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存 |
| [hashCode](hash-code.html) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>计算组件哈希值 |

