---
title: org.mechdancer.remote.modules.multicast - 
---

[org.mechdancer.remote.modules.multicast](./index.html)

## Package org.mechdancer.remote.modules.multicast

### Types

| [MulticastBroadcaster](-multicast-broadcaster/index.html) | `class MulticastBroadcaster : UniqueComponent<`[`MulticastBroadcaster`](-multicast-broadcaster/index.html)`>, Dependent`<br>组播发布者 |
| [MulticastListener](-multicast-listener/index.html) | `interface MulticastListener : Component`<br>组播监听者 |
| [MulticastReceiver](-multicast-receiver/index.html) | `class MulticastReceiver : UniqueComponent<`[`MulticastReceiver`](-multicast-receiver/index.html)`>, Dependent`<br>组播小包接收 |
| [PacketSlicer](-packet-slicer/index.html) | `class PacketSlicer : UniqueComponent<`[`PacketSlicer`](-packet-slicer/index.html)`>, Dependent, `[`MulticastListener`](-multicast-listener/index.html)<br>数据包分片协议 |

### Functions

| [multicastListener](multicast-listener.html) | `fun multicastListener(vararg interest: `[`Command`](../org.mechdancer.remote.resources/-command/index.html)` = arrayOf(UdpCmd.COMMON), block: (sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, cmd: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MulticastListener`](-multicast-listener/index.html)<br>构造组播监听者 |

