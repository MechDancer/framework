---
title: TcpFeedbackCmd - 
---

[org.mechdancer.remote.resources](../index.html) / [TcpFeedbackCmd](./index.html)

# TcpFeedbackCmd

`enum class TcpFeedbackCmd : `[`Command`](../-command/index.html)

### Enum Values

| [DECLINE](-d-e-c-l-i-n-e.html) |  |

### Properties

| [id](id.html) | `val id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>命令识别码 |

### Inherited Functions

| [lead](../-command/lead.html) | `open fun lead(payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>基于指令构造包 |

### Companion Object Functions

| [get](get.html) | `operator fun get(id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`TcpFeedbackCmd`](./index.html)`?` |

