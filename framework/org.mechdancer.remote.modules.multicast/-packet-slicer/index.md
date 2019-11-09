---
title: PacketSlicer - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.multicast](../index.html) / [PacketSlicer](./index.html)

# PacketSlicer

`class PacketSlicer : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`PacketSlicer`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](../-multicast-listener/index.html)

数据包分片协议

### Constructors

| [&lt;init&gt;](-init-.html) | 数据包分片协议`PacketSlicer()` |

### Properties

| [interest](interest.html) | `val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`UdpCmd`](../../org.mechdancer.remote.resources/-udp-cmd/index.html)`>` |

### Functions

| [process](process.html) | `fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refresh](refresh.html) | 清理缓冲中最后活跃时间超过 [timeout](refresh.html#org.mechdancer.remote.modules.multicast.PacketSlicer$refresh(kotlin.Int)/timeout)ms 的数据包`fun refresh(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

