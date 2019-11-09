---
title: MulticastReceiver - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.multicast](../index.html) / [MulticastReceiver](./index.html)

# MulticastReceiver

`class MulticastReceiver : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastReceiver`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)

组播小包接收

### Parameters

`bufferSize` - 缓冲区容量

### Constructors

| [&lt;init&gt;](-init-.html) | 组播小包接收`MulticastReceiver(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 65536, rule: `[`Rule`](../../org.mechdancer.remote.modules.group/-rule/index.html)` = Rule())` |

### Functions

| [invoke](invoke.html) | `operator fun invoke(): `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`?` |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

