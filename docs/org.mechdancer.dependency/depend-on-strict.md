---
title: dependOnStrict - 
---

[org.mechdancer.dependency](index.html) / [dependOnStrict](./depend-on-strict.html)

# dependOnStrict

`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<`[`C`](depend-on-strict.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`C`](depend-on-strict.html#C)`>): `[`Dependency`](-type-safe-dependency/-dependency/index.html)`<`[`C`](depend-on-strict.html#C)`>`
`fun <C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](depend-on-strict.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`C`](depend-on-strict.html#C)`>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Dependency`](-type-safe-dependency/-dependency/index.html)`<`[`C`](depend-on-strict.html#C)`>`

构造一个 [C](depend-on-strict.html#C) 类型的强依赖

