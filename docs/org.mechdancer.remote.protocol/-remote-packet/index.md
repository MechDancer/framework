---
title: RemotePacket - 
---

[org.mechdancer.remote.protocol](../index.html) / [RemotePacket](./index.html)

# RemotePacket

`class RemotePacket`

通用数据包
用于无连接通信或建立连接

### Parameters

`command` - 指令识别号

`sender` - 发送方名字

`payload` - 数据负载

### Constructors

| [&lt;init&gt;](-init-.html) | `RemotePacket(sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, command: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`)`<br>通用数据包 用于无连接通信或建立连接 |

### Properties

| [command](command.html) | `val command: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>指令识别号 |
| [payload](payload.html) | `val payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>数据负载 |
| [sender](sender.html) | `val sender: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>发送方名字 |

### Functions

| [component1](component1.html) | `operator fun component1(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [component2](component2.html) | `operator fun component2(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [component3](component3.html) | `operator fun component3(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [toString](to-string.html) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

