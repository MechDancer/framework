---
title: TcpCmd - 
---

[org.mechdancer.remote.resources](../index.html) / [TcpCmd](./index.html)

# TcpCmd

`enum class TcpCmd : `[`Command`](../-command/index.html)

TCP 协议指令

### Enum Values

| [Mail](-mail.html) |  |
| [Dialog](-dialog.html) |  |
| [Blocking](-blocking.html) |  |
| [COMMON](-c-o-m-m-o-n.html) |  |

### Properties

| [id](id.html) | `val id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>命令识别码 |

### Inherited Functions

| [lead](../-command/lead.html) | `open fun lead(payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>基于指令构造包 |

### Companion Object Functions

| [get](get.html) | `operator fun get(id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`TcpCmd`](./index.html)`?` |

