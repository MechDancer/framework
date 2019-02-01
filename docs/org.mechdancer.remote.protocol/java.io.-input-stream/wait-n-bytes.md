---
title: waitNBytes - 
---

[org.mechdancer.remote.protocol](../index.html) / [java.io.InputStream](index.html) / [waitNBytes](./wait-n-bytes.html)

# waitNBytes

`infix fun `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`.waitNBytes(n: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

从输入流阻塞接收 [n](wait-n-bytes.html#org.mechdancer.remote.protocol$waitNBytes(java.io.InputStream, kotlin.Int)/n) 个字节数据，或直到流关闭。
函数会直接打开等于目标长度的缓冲区，因此不要用于实现尽量读取的功能。

