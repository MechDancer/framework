---
title: SimpleInputStream - framework
---

[framework](../../index.html) / [org.mechdancer.remote.protocol](../index.html) / [SimpleInputStream](./index.html)

# SimpleInputStream

`class SimpleInputStream : `[`InputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)

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

