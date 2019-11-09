---
title: must - framework
---

[framework](../index.html) / [org.mechdancer.dependency](index.html) / [must](./must.html)

# must

`fun <reified C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.must(): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C>`
`fun <reified C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.must(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Dependent`](-dependent/index.html)`, C>`

构造一个 [C](must.html#C) 类型的强依赖属性代理

