---
title: Networks - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [Networks](./index.html)

# Networks

`class Networks : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`Networks`](./index.html)`>`

网络端口扫描器

### Constructors

| [&lt;init&gt;](-init-.html) | 网络端口扫描器`Networks()` |

### Properties

| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`, `[`InterfaceAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InterfaceAddress.html)`>` |

### Functions

| [get](get.html) | `fun get(parameter: `[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`): `[`InterfaceAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InterfaceAddress.html)`?` |
| [scan](scan.html) | 扫描全部 IP 地址 耗时为亚秒级，谨慎使用`fun scan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

