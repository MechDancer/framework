---
title: MulticastBroadcaster - 
---

[org.mechdancer.remote.modules.multicast](../index.html) / [MulticastBroadcaster](./index.html)

# MulticastBroadcaster

`class MulticastBroadcaster : UniqueComponent<`[`MulticastBroadcaster`](./index.html)`>, Dependent`

组播发布者

### Parameters

`size` - UDP 包分片长度

### Constructors

| [&lt;init&gt;](-init-.html) | `MulticastBroadcaster(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0x4000)`<br>组播发布者 |

### Functions

| [broadcast](broadcast.html) | `fun broadcast(cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)` = ByteArray(0)): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>通过组播发送: &lt;[cmd](broadcast.html#org.mechdancer.remote.modules.multicast.MulticastBroadcaster$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/cmd): Byte&gt;&lt;[name](#): 0结尾字符串&gt;&lt;[payload](broadcast.html#org.mechdancer.remote.modules.multicast.MulticastBroadcaster$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/payload)&gt; |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

