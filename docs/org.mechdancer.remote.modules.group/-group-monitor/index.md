---
title: GroupMonitor - 
---

[org.mechdancer.remote.modules.group](../index.html) / [GroupMonitor](./index.html)

# GroupMonitor

`class GroupMonitor : UniqueComponent<`[`GroupMonitor`](./index.html)`>, Dependent`

组成员的管理器

监听到达节点的所有通信，包括UDP和TCP

### Constructors

| [&lt;init&gt;](-init-.html) | `GroupMonitor()`<br>组成员的管理器 |

### Functions

| [detect](detect.html) | `fun detect(node: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, reply: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>更新[node](detect.html#org.mechdancer.remote.modules.group.GroupMonitor$detect(kotlin.String, kotlin.Boolean)/node)出现时间并回复 |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [yell](yell.html) | `fun yell(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>请求组中的成员响应，以证实存在性，要使用此功能必须依赖组播发送 |

