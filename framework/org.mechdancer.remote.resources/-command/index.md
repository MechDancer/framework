---
title: Command - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [Command](./index.html)

# Command

`interface Command`

命令接口

### Types

| [CommandMemory](-command-memory/index.html) | 命令缓存，使第二次查找具有 O(1) 复杂度`class CommandMemory<C : `[`Command`](./index.html)`>` |

### Properties

| [id](id.html) | 命令识别码`abstract val id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |

### Functions

| [lead](lead.html) | 基于指令构造包`open fun lead(payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |

### Companion Object Functions

| [memoryOf](memory-of.html) | 自动构造缓存`fun <C> memoryOf(): CommandMemory<C> where C : `[`Command`](./index.html)`, C : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<C>` |

### Inheritors

| [TcpCmd](../-tcp-cmd/index.html) | TCP 协议指令`enum class TcpCmd : `[`Command`](./index.html) |
| [TcpFeedbackCmd](../-tcp-feedback-cmd/index.html) | `enum class TcpFeedbackCmd : `[`Command`](./index.html) |
| [UdpCmd](../-udp-cmd/index.html) | 组播协议`enum class UdpCmd : `[`Command`](./index.html) |

