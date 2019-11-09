---
title: UdpCmd - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [UdpCmd](./index.html)

# UdpCmd

`enum class UdpCmd : `[`Command`](../-command/index.html)

组播协议

### Enum Values

| [YELL_ASK](-y-e-l-l_-a-s-k.html) | 存在性请求 |
| [YELL_ACK](-y-e-l-l_-a-c-k.html) | 存在性回复 |
| [ADDRESS_ASK](-a-d-d-r-e-s-s_-a-s-k.html) | 地址请求 |
| [ADDRESS_ACK](-a-d-d-r-e-s-s_-a-c-k.html) | 地址回复 |
| [PACKET_SLICE](-p-a-c-k-e-t_-s-l-i-c-e.html) | 包分片 |
| [TOPIC_MESSAGE](-t-o-p-i-c_-m-e-s-s-a-g-e.html) | 话题消息 |
| [COMMON](-c-o-m-m-o-n.html) | 通用广播 |

### Properties

| [id](id.html) | 命令识别码`val id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |

### Companion Object Functions

| [get](get.html) | `operator fun get(id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`UdpCmd`](./index.html)`?` |

