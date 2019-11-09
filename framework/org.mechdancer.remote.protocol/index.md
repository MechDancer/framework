---
title: org.mechdancer.remote.protocol - framework
---

[framework](../index.html) / [org.mechdancer.remote.protocol](./index.html)

## Package org.mechdancer.remote.protocol

### Types

| [RemotePacket](-remote-packet/index.html) | 通用数据包 用于无连接通信或建立连接`class RemotePacket` |
| [SimpleInputStream](-simple-input-stream/index.html) | `class SimpleInputStream : `[`InputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html) |
| [SimpleOutputStream](-simple-output-stream/index.html) | `class SimpleOutputStream : `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html) |

### Extensions for External Classes

| [java.io.InputStream](java.io.-input-stream/index.html) |  |
| [java.io.OutputStream](java.io.-output-stream/index.html) |  |
| [kotlin.ByteArray](kotlin.-byte-array/index.html) |  |
| [kotlin.Long](kotlin.-long/index.html) |  |

### Functions

| [zigzag](zigzag.html) | 在流上编码变长整数`fun <T : `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`> T.zigzag(num: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, signed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): T` |

