---
title: PacketSlicer - 
---

[org.mechdancer.remote.modules.multicast](../index.html) / [PacketSlicer](./index.html)

# PacketSlicer

`class PacketSlicer : UniqueComponent<`[`PacketSlicer`](./index.html)`>, Dependent, `[`MulticastListener`](../-multicast-listener/index.html)

数据包分片协议

### Constructors

| [&lt;init&gt;](-init-.html) | `PacketSlicer()`<br>数据包分片协议 |

### Properties

| [interest](interest.html) | `val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`UdpCmd`](../../org.mechdancer.remote.resources/-udp-cmd/index.html)`>` |

### Functions

| [process](process.html) | `fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refresh](refresh.html) | `fun refresh(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>清理缓冲中最后活跃时间超过 [timeout](refresh.html#org.mechdancer.remote.modules.multicast.PacketSlicer$refresh(kotlin.Int)/timeout)ms 的数据包 |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

