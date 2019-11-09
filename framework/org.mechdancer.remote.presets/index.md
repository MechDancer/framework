---
title: org.mechdancer.remote.presets - framework
---

[framework](../index.html) / [org.mechdancer.remote.presets](./index.html)

## Package org.mechdancer.remote.presets

### Types

| [Pacemaker](-pacemaker/index.html) | 起搏器`class Pacemaker` |
| [Probe](-probe/index.html) | 探针`class Probe` |
| [RemoteDsl](-remote-dsl/index.html) | 远程终端构建器`class RemoteDsl` |
| [RemoteHub](-remote-hub/index.html) | 远程终端`class RemoteHub : `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |

### Functions

| [pacemaker](pacemaker.html) | `fun pacemaker(group: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, loggerSetting: (Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)? = null): `[`Pacemaker`](-pacemaker/index.html) |
| [probe](probe.html) | `fun probe(group: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, loggerSetting: (Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)? = null): `[`Probe`](-probe/index.html) |
| [remoteHub](remote-hub.html) | `fun remoteHub(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, address: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)` = GROUP, sliceSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0x4000, block: `[`RemoteDsl`](-remote-dsl/index.html)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`RemoteHub`](-remote-hub/index.html) |

