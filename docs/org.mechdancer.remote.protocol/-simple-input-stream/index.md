---
title: SimpleInputStream - 
---

[org.mechdancer.remote.protocol](../index.html) / [SimpleInputStream](./index.html)

# SimpleInputStream

`class SimpleInputStream : `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SimpleInputStream(core: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, ptr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = core.size)` |

### Properties

| [core](core.html) | `val core: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |

### Functions

| [available](available.html) | `fun available(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [close](close.html) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [look](look.html) | `fun look(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [lookRest](look-rest.html) | `fun lookRest(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [read](read.html) | `fun read(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readInto](read-into.html) | `fun readInto(stream: `[`SimpleOutputStream`](../-simple-output-stream/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [skip](skip.html) | `infix fun skip(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`SimpleInputStream`](./index.html) |

### Extension Functions

| [readEnd](../java.io.-input-stream/read-end.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.readEnd(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>从流读取一个带结尾的字符串 |
| [readWithLength](../java.io.-input-stream/read-with-length.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.readWithLength(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>先从流读出长度，再从流读出数据 |
| [waitNBytes](../java.io.-input-stream/wait-n-bytes.html) | `infix fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.waitNBytes(n: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>从输入流阻塞接收 [n](../java.io.-input-stream/wait-n-bytes.html#org.mechdancer.remote.protocol$waitNBytes(java.io.InputStream, kotlin.Int)/n) 个字节数据，或直到流关闭。 函数会直接打开等于目标长度的缓冲区，因此不要用于实现尽量读取的功能。 |
| [zigzag](../java.io.-input-stream/zigzag.html) | `fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.zigzag(signed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>在流上解码变长整数 |

