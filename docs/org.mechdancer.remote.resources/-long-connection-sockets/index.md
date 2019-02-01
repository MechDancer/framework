---
title: LongConnectionSockets - 
---

[org.mechdancer.remote.resources](../index.html) / [LongConnectionSockets](./index.html)

# LongConnectionSockets

`class LongConnectionSockets : UniqueComponent<`[`LongConnectionSockets`](./index.html)`>, `[`Closeable`](http://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

长连接套接字

### Constructors

| [&lt;init&gt;](-init-.html) | `LongConnectionSockets()`<br>长连接套接字 |

### Properties

| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`>` |

### Functions

| [close](close.html) | `fun close(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.html) | `operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?` |
| [getOrSet](get-or-set.html) | `fun getOrSet(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: () -> `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?): `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`?` |
| [set](set.html) | `operator fun set(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, socket: `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

