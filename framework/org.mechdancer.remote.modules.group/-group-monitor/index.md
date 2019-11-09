---
title: GroupMonitor - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.group](../index.html) / [GroupMonitor](./index.html)

# GroupMonitor

`class GroupMonitor : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`GroupMonitor`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

组成员的管理器

监听到达节点的所有通信，包括UDP和TCP

### Constructors

| [&lt;init&gt;](-init-.html) | 组成员的管理器`GroupMonitor()` |

### Functions

| [detect](detect.html) | 更新[node](detect.html#org.mechdancer.remote.modules.group.GroupMonitor$detect(kotlin.String, kotlin.Boolean)/node)出现时间并回复`fun detect(node: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, reply: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [yell](yell.html) | 请求组中的成员响应，以证实存在性，要使用此功能必须依赖组播发送`fun yell(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

