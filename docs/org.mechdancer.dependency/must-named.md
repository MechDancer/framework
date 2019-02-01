---
title: mustNamed - 
---

[org.mechdancer.dependency](index.html) / [mustNamed](./must-named.html)

# mustNamed

`inline fun <reified C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](must-named.html#C)`>, T> `[`DependencyManager`](-dependency-manager/index.html)`.mustNamed(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, crossinline block: (`[`C`](must-named.html#C)`) -> `[`T`](must-named.html#T)`): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`T`](must-named.html#T)`>`

从一个 [C](must-named.html#C) 类型的强依赖取值

