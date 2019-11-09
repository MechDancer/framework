---
title: dependOnStrict - framework
---

[framework](../index.html) / [org.mechdancer.dependency](index.html) / [dependOnStrict](./depend-on-strict.html)

# dependOnStrict

`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>): Dependency<C>`
`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnStrict(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Dependency<C>`

构造一个 [C](depend-on-strict.html#C) 类型的强依赖

