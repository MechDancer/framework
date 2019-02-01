---
title: Command - 
---

[org.mechdancer.remote.resources](../index.html) / [Command](./index.html)

# Command

`interface Command`

命令接口

### Types

| [CommandMemory](-command-memory/index.html) | `class CommandMemory<C : `[`Command`](./index.html)`>`<br>命令缓存，使第二次查找具有 O(1) 复杂度 |

### Properties

| [id](id.html) | `abstract val id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>命令识别码 |

### Functions

| [lead](lead.html) | `open fun lead(payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>基于指令构造包 |

### Companion Object Functions

| [memoryOf](memory-of.html) | `fun <C> memoryOf(): `[`CommandMemory`](-command-memory/index.html)`<`[`C`](memory-of.html#C)`> where C : `[`Command`](./index.html)`, C : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<`[`C`](memory-of.html#C)`>`<br>自动构造缓存 |

### Inheritors

| [TcpCmd](../-tcp-cmd/index.html) | `enum class TcpCmd : `[`Command`](./index.html)<br>TCP 协议指令 |
| [TcpFeedbackCmd](../-tcp-feedback-cmd/index.html) | `enum class TcpFeedbackCmd : `[`Command`](./index.html) |
| [UdpCmd](../-udp-cmd/index.html) | `enum class UdpCmd : `[`Command`](./index.html)<br>组播协议 |

