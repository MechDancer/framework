---
title: MulticastSockets - 
---

[org.mechdancer.remote.resources](../index.html) / [MulticastSockets](./index.html)

# MulticastSockets

`class MulticastSockets : UniqueComponent<`[`MulticastSockets`](./index.html)`>, `[`Closeable`](http://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

组播套接字资源

### Parameters

`address` - 组地址

### Constructors

| [&lt;init&gt;](-init-.html) | `MulticastSockets(address: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`)`<br>组播套接字资源 |

### Properties

| [address](address.html) | `val address: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)<br>组地址 |
| [default](default.html) | `val default: `[`MulticastSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)<br>默认套接字 |
| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`, `[`MulticastSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)`>` |

### Functions

| [close](close.html) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>关闭所有发送套接字 |
| [get](get.html) | `operator fun get(parameter: `[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`): `[`MulticastSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)<br>获取经由 [parameter](get.html#org.mechdancer.remote.resources.MulticastSockets$get(java.net.NetworkInterface)/parameter) 发送的组播套接字`operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`MulticastSocket`](http://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)<br>获取指定超时时间 [timeout](get.html#org.mechdancer.remote.resources.MulticastSockets$get(kotlin.Int)/timeout) 的临时套接字 |

