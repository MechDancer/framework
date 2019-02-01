---
title: MulticastReceiver - 
---

[org.mechdancer.remote.modules.multicast](../index.html) / [MulticastReceiver](./index.html)

# MulticastReceiver

`class MulticastReceiver : UniqueComponent<`[`MulticastReceiver`](./index.html)`>, Dependent`

组播小包接收

### Parameters

`bufferSize` - 缓冲区容量

### Constructors

| [&lt;init&gt;](-init-.html) | `MulticastReceiver(bufferSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 65536, rule: `[`Rule`](../../org.mechdancer.remote.modules.group/-rule/index.html)` = Rule())`<br>组播小包接收 |

### Functions

| [invoke](invoke.html) | `operator fun invoke(): `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`?` |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

