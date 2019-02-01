---
title: DynamicScope.setup - 
---

[org.mechdancer.dependency](../index.html) / [DynamicScope](index.html) / [setup](./setup.html)

# setup

`open infix fun setup(component: `[`Component`](../-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

将一个新的组件加入到动态域，返回是否成功添加

**Return**
若组件被添加到域，返回 `true`
    与已有的组件发生冲突时返回 `false`

