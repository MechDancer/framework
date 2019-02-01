---
title: org.mechdancer.remote.protocol.java.io.InputStream - 
---

[org.mechdancer.remote.protocol](../index.html) / [java.io.InputStream](./index.html)

### Extensions for java.io.InputStream

| [readEnd](read-end.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.readEnd(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>从流读取一个带结尾的字符串 |
| [readWithLength](read-with-length.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.readWithLength(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>先从流读出长度，再从流读出数据 |
| [waitNBytes](wait-n-bytes.html) | `infix fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.waitNBytes(n: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>从输入流阻塞接收 [n](wait-n-bytes.html#org.mechdancer.remote.protocol$waitNBytes(java.io.InputStream, kotlin.Int)/n) 个字节数据，或直到流关闭。 函数会直接打开等于目标长度的缓冲区，因此不要用于实现尽量读取的功能。 |
| [zigzag](zigzag.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.zigzag(signed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>在流上解码变长整数 |

