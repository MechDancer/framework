---
title: DynamicScope - 
---

[org.mechdancer.dependency](../index.html) / [DynamicScope](./index.html)

# DynamicScope

`open class DynamicScope`

动态域

动态域允许向其中动态地添加新的组件
组件被添加到动态域时，将执行一系列操作，以自动解算依赖关系和建立组件关联

### Constructors

| [&lt;init&gt;](-init-.html) | `DynamicScope()`<br>动态域 |

### Properties

| [components](components.html) | `val components: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Component`](../-component/index.html)`>`<br>浏览所有组件 |

### Functions

| [setup](setup.html) | `open infix fun setup(component: `[`Component`](../-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>将一个新的组件加入到动态域，返回是否成功添加 |

### Extension Functions

| [plusAssign](../plus-assign.html) | `operator fun `[`DynamicScope`](./index.html)`.plusAssign(component: `[`Component`](../-component/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>向动态域添加新的依赖项 |
| [setup](../setup.html) | `fun <T : `[`Component`](../-component/index.html)`> `[`DynamicScope`](./index.html)`.setup(component: `[`T`](../setup.html#T)`, block: `[`T`](../setup.html#T)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>向动态域添加并执行一个操作 |

