---
title: ConnectionClient - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.tcpconnection](../index.html) / [ConnectionClient](./index.html)

# ConnectionClient

`class ConnectionClient : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`ConnectionClient`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

短连接客户端

### Constructors

| [&lt;init&gt;](-init-.html) | 短连接客户端`ConnectionClient()` |

### Functions

| [connect](connect.html) | 连接一个远端`fun connect(server: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`): `[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?` |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

