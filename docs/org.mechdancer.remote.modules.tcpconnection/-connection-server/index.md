---
title: ConnectionServer - 
---

[org.mechdancer.remote.modules.tcpconnection](../index.html) / [ConnectionServer](./index.html)

# ConnectionServer

`class ConnectionServer : UniqueComponent<`[`ConnectionServer`](./index.html)`>, Dependent`

TCP 连接服务器

### Constructors

| [&lt;init&gt;](-init-.html) | `ConnectionServer(rule: `[`Rule`](../../org.mechdancer.remote.modules.group/-rule/index.html)` = Rule())`<br>TCP 连接服务器 |

### Functions

| [invoke](invoke.html) | `operator fun invoke(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>打开特定 [port](invoke.html#org.mechdancer.remote.modules.tcpconnection.ConnectionServer$invoke(kotlin.Int)/port) 接收TCP连接 |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

