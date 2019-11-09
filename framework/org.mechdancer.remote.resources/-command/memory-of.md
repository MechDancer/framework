---
title: Command.memoryOf - framework
---

[framework](../../index.html) / [org.mechdancer.remote.resources](../index.html) / [Command](index.html) / [memoryOf](./memory-of.html)

# memoryOf

`fun <reified C> memoryOf(): CommandMemory<C> where C : `[`Command`](index.html)`, C : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<C>`

自动构造缓存

### Parameters

`C` - 指令类型