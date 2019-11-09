---
title: NamedComponent - framework
---

[framework](../../index.html) / [org.mechdancer.dependency](../index.html) / [NamedComponent](./index.html)

# NamedComponent

`abstract class NamedComponent<T : `[`NamedComponent`](./index.html)`<T>> : `[`Component`](../-component/index.html)

具名组件

同类型且同名的组件不可共存

### Constructors

| [&lt;init&gt;](-init-.html) | 具名组件`NamedComponent(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>? = null)` |

### Properties

| [name](name.html) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.html) | `val type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>` |

### Functions

| [equals](equals.html) | 判断能否与[other](../-component/equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存`open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.html) | 计算组件哈希值`open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

