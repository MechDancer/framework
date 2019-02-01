---
title: DependencyManager.must - 
---

[org.mechdancer.dependency](../index.html) / [DependencyManager](index.html) / [must](./must.html)

# must

`inline fun <reified C : `[`Component`](../-component/index.html)`, T> must(noinline predicate: (`[`C`](must.html#C)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, crossinline block: (`[`C`](must.html#C)`) -> `[`T`](must.html#T)`): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`T`](must.html#T)`>`

从一个 [C](must.html#C) 类型的强依赖取值

`inline fun <reified C : `[`Component`](../-component/index.html)`> must(noinline predicate: (`[`C`](must.html#C)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](../-dependent/index.html)`, `[`C`](must.html#C)`>`

构造一个 [C](must.html#C) 类型的强依赖属性代理

