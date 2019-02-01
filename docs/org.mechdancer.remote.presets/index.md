---
title: org.mechdancer.remote.presets - 
---

[org.mechdancer.remote.presets](./index.html)

## Package org.mechdancer.remote.presets

### Types

| [Pacemaker](-pacemaker/index.html) | `class Pacemaker`<br>起搏器 |
| [Probe](-probe/index.html) | `class Probe`<br>探针 |
| [RemoteDsl](-remote-dsl/index.html) | `class RemoteDsl`<br>远程终端构建器 |
| [RemoteHub](-remote-hub/index.html) | `class RemoteHub : `[`Closeable`](http://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)<br>远程终端 |

### Functions

| [pacemaker](pacemaker.html) | `fun pacemaker(group: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, loggerSetting: Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = null): `[`Pacemaker`](-pacemaker/index.html) |
| [probe](probe.html) | `fun probe(group: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, loggerSetting: Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = null): `[`Probe`](-probe/index.html) |
| [remoteHub](remote-hub.html) | `fun remoteHub(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, address: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, sliceSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0x4000, block: `[`RemoteDsl`](-remote-dsl/index.html)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`RemoteHub`](-remote-hub/index.html) |

