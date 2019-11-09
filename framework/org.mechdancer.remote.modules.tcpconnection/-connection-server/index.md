---
title: ConnectionServer - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.tcpconnection](../index.html) / [ConnectionServer](./index.html)

# ConnectionServer

`class ConnectionServer : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`ConnectionServer`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

TCP 连接服务器

### Constructors

| [&lt;init&gt;](-init-.html) | TCP 连接服务器`ConnectionServer(rule: `[`Rule`](../../org.mechdancer.remote.modules.group/-rule/index.html)` = Rule())` |

### Functions

| [invoke](invoke.html) | 打开特定 [port](invoke.html#org.mechdancer.remote.modules.tcpconnection.ConnectionServer$invoke(kotlin.Int)/port) 接收TCP连接`operator fun invoke(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

