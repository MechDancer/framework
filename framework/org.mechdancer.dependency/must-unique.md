---
title: mustUnique - framework
---

[framework](../index.html) / [org.mechdancer.dependency](index.html) / [mustUnique](./must-unique.html)

# mustUnique

`inline fun <reified C : `[`UniqueComponent`](-unique-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.mustUnique(crossinline block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>`

从一个 [C](must-unique.html#C) 类型的强依赖取值

