---
title: Dependent - 
---

[org.mechdancer.dependency](../index.html) / [Dependent](./index.html)

# Dependent

`interface Dependent : `[`Component`](../-component/index.html)

依赖者

依赖者的内容不完整，需要获得依赖项的支持
因此当一个新的依赖项到达，依赖者会得到通知，直到所有依赖项都集齐为止

### Functions

| [sync](sync.html) | `abstract fun sync(dependency: `[`Component`](../-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>向依赖者展示新的依赖项[dependency](sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项 |

### Inherited Functions

| [equals](../-component/equals.html) | `abstract fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>判断能否与[other](../-component/equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存 |
| [hashCode](../-component/hash-code.html) | `abstract fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>计算组件哈希值 |

