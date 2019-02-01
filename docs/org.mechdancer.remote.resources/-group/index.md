---
title: Group - 
---

[org.mechdancer.remote.resources](../index.html) / [Group](./index.html)

# Group

`class Group : UniqueComponent<`[`Group`](./index.html)`>`

成员存在性资源

### Constructors

| [&lt;init&gt;](-init-.html) | `Group()`<br>成员存在性资源 |

### Properties

| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |

### Functions

| [detect](detect.html) | `fun detect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?`<br>更新出现时间 |
| [get](get.html) | `operator fun get(parameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?`<br>读取出现时间`operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>获取最后出现时间短于超时时间 [timeout](get.html#org.mechdancer.remote.resources.Group$get(kotlin.Int)/timeout) 的成员 |

