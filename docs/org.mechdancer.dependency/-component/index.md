---
title: Component - 
---

[org.mechdancer.dependency](../index.html) / [Component](./index.html)

# Component

`interface Component`

组件

通过类型反射、哈希值和判等条件与其他组件区分开
因此组件可以安全快捷地保存到一个哈希集合中

### Functions

| [equals](equals.html) | `abstract fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>判断能否与[other](equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存 |
| [hashCode](hash-code.html) | `abstract fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>计算组件哈希值 |

### Inheritors

| [Dependent](../-dependent/index.html) | `interface Dependent : `[`Component`](./index.html)<br>依赖者 |
| [NamedComponent](../-named-component/index.html) | `abstract class NamedComponent<T : `[`NamedComponent`](../-named-component/index.html)`<`[`T`](../-named-component/index.html#T)`>> : `[`Component`](./index.html)<br>具名组件 |
| [UniqueComponent](../-unique-component/index.html) | `abstract class UniqueComponent<T : `[`UniqueComponent`](../-unique-component/index.html)`<`[`T`](../-unique-component/index.html#T)`>> : `[`Component`](./index.html)<br>唯一组件 |

