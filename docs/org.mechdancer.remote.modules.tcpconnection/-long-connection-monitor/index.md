---
title: LongConnectionMonitor - 
---

[org.mechdancer.remote.modules.tcpconnection](../index.html) / [LongConnectionMonitor](./index.html)

# LongConnectionMonitor

`class LongConnectionMonitor : UniqueComponent<`[`LongConnectionMonitor`](./index.html)`>, Dependent`

长连接管理（对等）

### Constructors

| [&lt;init&gt;](-init-.html) | `LongConnectionMonitor()`<br>长连接管理（对等） |

### Functions

| [close](close.html) | `fun close(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>关闭与 [name](close.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$close(kotlin.String)/name) 的连接 |
| [connect](connect.html) | `fun connect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?`<br>找到与 [name](connect.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$connect(kotlin.String)/name) 的连接或建立新的连接 |
| [process](process.html) | `fun <T> process(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: (`[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> `[`T`](process.html#T)`): `[`T`](process.html#T)`?`<br>使用与 [name](process.html#org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor$process(kotlin.String, kotlin.Function1((java.net.Socket, org.mechdancer.remote.modules.tcpconnection.LongConnectionMonitor.process.T)))/name) 的连接通信 |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

