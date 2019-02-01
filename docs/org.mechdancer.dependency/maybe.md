---
title: maybe - 
---

[org.mechdancer.dependency](index.html) / [maybe](./maybe.html)

# maybe

`inline fun <reified C : `[`UniqueComponent`](-unique-component/index.html)`<`[`C`](maybe.html#C)`>, T> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(default: `[`T`](maybe.html#T)`, crossinline block: (`[`C`](maybe.html#C)`) -> `[`T`](maybe.html#T)`): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`T`](maybe.html#T)`>`
`inline fun <reified C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](maybe.html#C)`>, T> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, default: `[`T`](maybe.html#T)`, crossinline block: (`[`C`](maybe.html#C)`) -> `[`T`](maybe.html#T)`): `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`T`](maybe.html#T)`>`

从一个 [C](maybe.html#C) 类型的弱依赖取值

`inline fun <reified C : `[`UniqueComponent`](-unique-component/index.html)`<`[`C`](maybe.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, `[`C`](maybe.html#C)`?>`
`inline fun <reified C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](maybe.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.maybe(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, `[`C`](maybe.html#C)`?>`

构造一个 [C](maybe.html#C) 类型的弱依赖属性代理

