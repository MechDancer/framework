---
title: RemotePacket - framework
---

[framework](../../index.html) / [org.mechdancer.remote.protocol](../index.html) / [RemotePacket](./index.html)

# RemotePacket

`class RemotePacket`

通用数据包
用于无连接通信或建立连接

### Parameters

`command` - 指令识别号

`sender` - 发送方名字

`payload` - 数据负载

### Constructors

| [&lt;init&gt;](-init-.html) | 通用数据包 用于无连接通信或建立连接`RemotePacket(sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, command: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`)` |

### Properties

| [command](command.html) | 指令识别号`val command: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [payload](payload.html) | 数据负载`val payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [sender](sender.html) | 发送方名字`val sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [component1](component1.html) | `operator fun component1(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [component2](component2.html) | `operator fun component2(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [component3](component3.html) | `operator fun component3(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [toString](to-string.html) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

