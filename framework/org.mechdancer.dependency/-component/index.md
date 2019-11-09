---
title: Component - framework
---

[framework](../../index.html) / [org.mechdancer.dependency](../index.html) / [Component](./index.html)

# Component

`interface Component`

组件

通过类型反射、哈希值和判等条件与其他组件区分开
因此组件可以安全快捷地保存到一个哈希集合中

### Functions

| [equals](equals.html) | 判断能否与[other](equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存`abstract fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.html) | 计算组件哈希值`abstract fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| [ConnectionListener](../../org.mechdancer.remote.modules.tcpconnection/-connection-listener/index.html) | 短连接监听者`interface ConnectionListener : `[`Component`](./index.html) |
| [Dependent](../-dependent/index.html) | 依赖者`interface Dependent : `[`Component`](./index.html) |
| [MailListener](../../org.mechdancer.remote.modules.tcpconnection/-mail-listener/index.html) | `interface MailListener : `[`Component`](./index.html) |
| [MulticastListener](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) | 组播监听者`interface MulticastListener : `[`Component`](./index.html) |
| [NamedComponent](../-named-component/index.html) | 具名组件`abstract class NamedComponent<T : `[`NamedComponent`](../-named-component/index.html)`<T>> : `[`Component`](./index.html) |
| [UniqueComponent](../-unique-component/index.html) | 唯一组件`abstract class UniqueComponent<T : `[`UniqueComponent`](../-unique-component/index.html)`<T>> : `[`Component`](./index.html) |

