---
title: must - 
---

[org.mechdancer.dependency](index.html) / [must](./must.html)

# must

`inline fun <reified C : `[`UniqueComponent`](-unique-component/index.html)`<`[`C`](must.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.must(): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, `[`C`](must.html#C)`>`
`inline fun <reified C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](must.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.must(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, `[`C`](must.html#C)`>`

构造一个 [C](must.html#C) 类型的强依赖属性代理

