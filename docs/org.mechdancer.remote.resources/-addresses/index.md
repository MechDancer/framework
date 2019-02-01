---
title: Addresses - 
---

[org.mechdancer.remote.resources](../index.html) / [Addresses](./index.html)

# Addresses

`class Addresses : UniqueComponent<`[`Addresses`](./index.html)`>`

地址资源

记录成员的地址和端口

### Constructors

| [&lt;init&gt;](-init-.html) | `Addresses()`<br>地址资源 |

### Functions

| [get](get.html) | `operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?` |
| [remove](remove.html) | `infix fun remove(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?` |
| [set](set.html) | `operator fun set(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, address: `[`Inet4Address`](http://docs.oracle.com/javase/6/docs/api/java/net/Inet4Address.html)`): `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?`<br>`operator fun set(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?`<br>`operator fun set(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, socket: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`): `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?` |

