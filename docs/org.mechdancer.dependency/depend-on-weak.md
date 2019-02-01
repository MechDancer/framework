---
title: dependOnWeak - 
---

[org.mechdancer.dependency](index.html) / [dependOnWeak](./depend-on-weak.html)

# dependOnWeak

`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<`[`C`](depend-on-weak.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`C`](depend-on-weak.html#C)`>): `[`WeakDependency`](-type-safe-dependency/-weak-dependency/index.html)`<`[`C`](depend-on-weak.html#C)`>`
`fun <C : `[`NamedComponent`](-named-component/index.html)`<`[`C`](depend-on-weak.html#C)`>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<`[`C`](depend-on-weak.html#C)`>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`WeakDependency`](-type-safe-dependency/-weak-dependency/index.html)`<`[`C`](depend-on-weak.html#C)`>`

构造一个 [C](depend-on-weak.html#C) 类型的弱依赖

