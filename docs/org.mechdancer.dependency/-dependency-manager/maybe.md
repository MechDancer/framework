---
title: DependencyManager.maybe - 
---

[org.mechdancer.dependency](../index.html) / [DependencyManager](index.html) / [maybe](./maybe.html)

# maybe

`inline fun <reified C : `[`Component`](../-component/index.html)`, T> maybe(noinline predicate: (`[`C`](maybe.html#C)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, default: `[`T`](maybe.html#T)`, crossinline block: (`[`C`](maybe.html#C)`) -> `[`T`](maybe.html#T)`): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`T`](maybe.html#T)`>`

从一个 [C](maybe.html#C) 类型的弱依赖取值

`inline fun <reified C : `[`Component`](../-component/index.html)`> maybe(noinline predicate: (`[`C`](maybe.html#C)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](../-dependent/index.html)`, `[`C`](maybe.html#C)`?>`

构造一个 [C](maybe.html#C) 类型的弱依赖属性代理

