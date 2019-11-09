---
title: ServerSockets - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [ServerSockets](./index.html)

# ServerSockets

`class ServerSockets : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`ServerSockets`](./index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

监听套接字资源

### Constructors

| [&lt;init&gt;](-init-.html) | 监听套接字资源`ServerSockets(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)` |

### Properties

| [default](default.html) | `val default: `[`ServerSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html) |
| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`ServerSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html)`>` |

### Functions

| [close](close.html) | 关闭所有套接字`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.html) | 获取或构造新的套接字资源`operator fun get(parameter: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ServerSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/ServerSocket.html)`?` |
| [isClosed](is-closed.html) | `fun isClosed(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

