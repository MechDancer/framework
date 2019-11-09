---
title: Command.CommandMemory - framework
---

[framework](../../../index.html) / [org.mechdancer.remote.resources](../../index.html) / [Command](../index.html) / [CommandMemory](./index.html)

# CommandMemory

`class CommandMemory<C : `[`Command`](../index.html)`>`

命令缓存，使第二次查找具有 O(1) 复杂度

### Parameters

`list` - 命令列表

### Constructors

| [&lt;init&gt;](-init-.html) | 命令缓存，使第二次查找具有 O(1) 复杂度`CommandMemory(list: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<C>)` |

### Functions

| [get](get.html) | 查询成员，成功则加入缓存`operator fun get(id: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): C?` |

