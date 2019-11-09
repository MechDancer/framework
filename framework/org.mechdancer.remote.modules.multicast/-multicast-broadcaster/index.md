---
title: MulticastBroadcaster - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.multicast](../index.html) / [MulticastBroadcaster](./index.html)

# MulticastBroadcaster

`class MulticastBroadcaster : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastBroadcaster`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

组播发布者

### Parameters

`size` - UDP 包分片长度

### Constructors

| [&lt;init&gt;](-init-.html) | 组播发布者`MulticastBroadcaster(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0x4000)` |

### Functions

| [broadcast](broadcast.html) | 通过组播发送: &lt;[cmd](broadcast.html#org.mechdancer.remote.modules.multicast.MulticastBroadcaster$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/cmd): Byte&gt;&lt;[name](#): 0结尾字符串&gt;&lt;[payload](broadcast.html#org.mechdancer.remote.modules.multicast.MulticastBroadcaster$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/payload)&gt;`fun broadcast(cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)` = ByteArray(0)): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

