---
title: org.mechdancer.remote.modules.multicast - framework
---

[framework](../index.html) / [org.mechdancer.remote.modules.multicast](./index.html)

## Package org.mechdancer.remote.modules.multicast

### Types

| [MulticastBroadcaster](-multicast-broadcaster/index.html) | 组播发布者`class MulticastBroadcaster : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastBroadcaster`](-multicast-broadcaster/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html) |
| [MulticastListener](-multicast-listener/index.html) | 组播监听者`interface MulticastListener : `[`Component`](../org.mechdancer.dependency/-component/index.html) |
| [MulticastReceiver](-multicast-receiver/index.html) | 组播小包接收`class MulticastReceiver : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastReceiver`](-multicast-receiver/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html) |
| [PacketSlicer](-packet-slicer/index.html) | 数据包分片协议`class PacketSlicer : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`PacketSlicer`](-packet-slicer/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](-multicast-listener/index.html) |

### Functions

| [multicastListener](multicast-listener.html) | 构造组播监听者`fun multicastListener(vararg interest: `[`Command`](../org.mechdancer.remote.resources/-command/index.html)` = arrayOf(UdpCmd.COMMON), block: (sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, cmd: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MulticastListener`](-multicast-listener/index.html) |

