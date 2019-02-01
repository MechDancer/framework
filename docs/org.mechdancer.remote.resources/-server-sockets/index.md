---
title: ServerSockets - 
---

[org.mechdancer.remote.resources](../index.html) / [ServerSockets](./index.html)

# ServerSockets

`class ServerSockets : UniqueComponent<`[`ServerSockets`](./index.html)`>, `[`Closeable`](http://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

监听套接字资源

### Constructors

| [&lt;init&gt;](-init-.html) | `ServerSockets(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`<br>监听套接字资源 |

### Properties

| [default](default.html) | `val default: `[`ServerSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html) |
| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`ServerSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html)`>` |

### Functions

| [close](close.html) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>关闭所有套接字 |
| [get](get.html) | `operator fun get(parameter: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ServerSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html)<br>获取或构造新的套接字资源 |
| [isClosed](is-closed.html) | `fun isClosed(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

