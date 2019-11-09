---
title: dependOnWeak - framework
---

[framework](../index.html) / [org.mechdancer.dependency](index.html) / [dependOnWeak](./depend-on-weak.html)

# dependOnWeak

`fun <C : `[`UniqueComponent`](-unique-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>): WeakDependency<C>`
`fun <C : `[`NamedComponent`](-named-component/index.html)`<C>> `[`DependencyManager`](-dependency-manager/index.html)`.dependOnWeak(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<C>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): WeakDependency<C>`

构造一个 [C](depend-on-weak.html#C) 类型的弱依赖

