---
title: Networks - 
---

[org.mechdancer.remote.resources](../index.html) / [Networks](./index.html)

# Networks

`class Networks : UniqueComponent<`[`Networks`](./index.html)`>`

网络端口扫描器

### Constructors

| [&lt;init&gt;](-init-.html) | `Networks()`<br>网络端口扫描器 |

### Properties

| [view](view.html) | `val view: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`, `[`InterfaceAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InterfaceAddress.html)`>` |

### Functions

| [get](get.html) | `fun get(parameter: `[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`): `[`InterfaceAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InterfaceAddress.html)`?` |
| [scan](scan.html) | `fun scan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>扫描全部 IP 地址 耗时为亚秒级，谨慎使用 |

