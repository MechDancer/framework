---
title: DynamicScope - framework
---

[framework](../../index.html) / [org.mechdancer.dependency](../index.html) / [DynamicScope](./index.html)

# DynamicScope

`open class DynamicScope`

动态域

动态域允许向其中动态地添加新的组件
组件被添加到动态域时，将执行一系列操作，以自动解算依赖关系和建立组件关联

### Constructors

| [&lt;init&gt;](-init-.html) | 动态域`DynamicScope()` |

### Properties

| [components](components.html) | 浏览所有组件`val components: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Component`](../-component/index.html)`>` |

### Functions

| [setup](setup.html) | 将一个新的组件加入到动态域，返回是否成功添加`open infix fun setup(component: `[`Component`](../-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Extension Functions

| [plusAssign](../plus-assign.html) | 向动态域添加新的依赖项`operator fun `[`DynamicScope`](./index.html)`.plusAssign(component: `[`Component`](../-component/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setup](../setup.html) | 向动态域添加并执行一个操作`fun <T : `[`Component`](../-component/index.html)`> `[`DynamicScope`](./index.html)`.setup(component: T, block: T.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

