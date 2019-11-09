---
title: MulticastSockets - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [MulticastSockets](./index.html)

# MulticastSockets

`class MulticastSockets : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastSockets`](./index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

组播套接字资源

### Parameters

`address` - 组地址

### Constructors

| [&lt;init&gt;](-init-.html) | 组播套接字资源`MulticastSockets(address: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`)` |

### Properties

| [address](address.html) | 组地址`val address: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html) |
| [default](default.html) | 默认套接字`val default: `[`MulticastSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html) |
| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`, `[`MulticastSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)`>` |

### Functions

| [close](close.html) | 关闭所有发送套接字`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.html) | 获取经由 [parameter](get.html#org.mechdancer.remote.resources.MulticastSockets$get(java.net.NetworkInterface)/parameter) 发送的组播套接字`operator fun get(parameter: `[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`): `[`MulticastSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html)<br>获取指定超时时间 [timeout](get.html#org.mechdancer.remote.resources.MulticastSockets$get(kotlin.Int)/timeout) 的临时套接字`operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`MulticastSocket`](https://docs.oracle.com/javase/6/docs/api/java/net/MulticastSocket.html) |

