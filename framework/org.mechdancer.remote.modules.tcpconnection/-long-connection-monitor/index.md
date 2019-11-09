---
title: LongConnectionMonitor - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.tcpconnection](../index.html) / [LongConnectionMonitor](./index.html)

# LongConnectionMonitor

`class LongConnectionMonitor : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`LongConnectionMonitor`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

长连接管理（对等）

### Constructors

| [&lt;init&gt;](-init-.html) | 长连接管理（对等）`LongConnectionMonitor()` |

### Functions

| [close](close.html) | 关闭与 [name](close.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$close(kotlin.String)/name) 的连接`fun close(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [connect](connect.html) | 找到与 [name](connect.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$connect(kotlin.String)/name) 的连接或建立新的连接`fun connect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?` |
| [process](process.html) | 使用与 [name](process.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$process(kotlin.String, kotlin.Function1((java.net.Socket, org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor.process.T)))/name) 的连接通信`fun <T> process(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: (`[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> T): T?` |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

