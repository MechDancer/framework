---
title: SimpleOutputStream - 
---

[org.mechdancer.remote.protocol](../index.html) / [SimpleOutputStream](./index.html)

# SimpleOutputStream

`class SimpleOutputStream : `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SimpleOutputStream(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| [core](core.html) | `val core: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [ptr](ptr.html) | `var ptr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| [available](available.html) | `fun available(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [clone](clone.html) | `fun clone(): `[`SimpleOutputStream`](./index.html) |
| [close](close.html) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [write](write.html) | `infix fun write(b: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`infix fun write(b: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`infix fun write(byteArray: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeFrom](write-from.html) | `fun writeFrom(stream: `[`SimpleInputStream`](../-simple-input-stream/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeLength](write-length.html) | `fun writeLength(byteArray: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, begin: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeRange](write-range.html) | `fun writeRange(byteArray: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, begin: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| [writeEnd](../java.io.-output-stream/write-end.html) | `fun `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`.writeEnd(string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)<br>向流写入 [string](../java.io.-output-stream/write-end.html#org.mechdancer.remote.protocol$writeEnd(java.io.OutputStream, kotlin.String)/string)，再写入结尾 |
| [writeWithLength](../java.io.-output-stream/write-with-length.html) | `infix fun `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`.writeWithLength(pack: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>先将长度写入流，再将 [pack](../java.io.-output-stream/write-with-length.html#org.mechdancer.remote.protocol$writeWithLength(java.io.OutputStream, kotlin.ByteArray)/pack) 写入流 |

