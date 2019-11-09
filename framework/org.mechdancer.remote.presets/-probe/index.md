---
title: Probe - framework
---

[framework](../../index.html) / [org.mechdancer.remote.presets](../index.html) / [Probe](./index.html)

# Probe

`class Probe`

探针

### Parameters

`group` - 组播地址和端口

### Constructors

| [&lt;init&gt;](-init-.html) | 探针`Probe(group: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`, loggerSetting: (Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?)` |

### Properties

| [group](group.html) | 组播地址和端口`val group: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html) |
| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?>>` |

### Functions

| [get](get.html) | `operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>`operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?, `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`?>` |
| [invoke](invoke.html) | `operator fun invoke(): `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`?` |

