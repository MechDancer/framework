---
title: mustNamed - framework
---

[framework](../index.html) / [org.mechdancer.dependency](index.html) / [mustNamed](./must-named.html)

# mustNamed

`inline fun <reified C : `[`NamedComponent`](-named-component/index.html)`<C>, T> `[`DependencyManager`](-dependency-manager/index.html)`.mustNamed(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, crossinline block: (C) -> T): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<T>`

从一个 [C](must-named.html#C) 类型的强依赖取值

