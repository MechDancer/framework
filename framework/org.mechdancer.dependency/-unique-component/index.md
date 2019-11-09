---
title: UniqueComponent - framework
---

[framework](../../index.html) / [org.mechdancer.dependency](../index.html) / [UniqueComponent](./index.html)

# UniqueComponent

`abstract class UniqueComponent<T : `[`UniqueComponent`](./index.html)`<T>> : `[`Component`](../-component/index.html)

唯一组件

同类型的组件不能共存

### Constructors

| [&lt;init&gt;](-init-.html) | 唯一组件`UniqueComponent(type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>? = null)` |

### Properties

| [type](type.html) | `val type: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>` |

### Functions

| [equals](equals.html) | 判断能否与[other](../-component/equals.html#org.mechdancer.dependency.Component$equals(kotlin.Any)/other)共存`open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.html) | 计算组件哈希值`open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| [Addresses](../../org.mechdancer.remote.resources/-addresses/index.html) | 地址资源`class Addresses : `[`UniqueComponent`](./index.html)`<`[`Addresses`](../../org.mechdancer.remote.resources/-addresses/index.html)`>` |
| [ConnectionClient](../../org.mechdancer.remote.modules.tcpconnection/-connection-client/index.html) | 短连接客户端`class ConnectionClient : `[`UniqueComponent`](./index.html)`<`[`ConnectionClient`](../../org.mechdancer.remote.modules.tcpconnection/-connection-client/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [ConnectionServer](../../org.mechdancer.remote.modules.tcpconnection/-connection-server/index.html) | TCP 连接服务器`class ConnectionServer : `[`UniqueComponent`](./index.html)`<`[`ConnectionServer`](../../org.mechdancer.remote.modules.tcpconnection/-connection-server/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [Group](../../org.mechdancer.remote.resources/-group/index.html) | 成员存在性资源`class Group : `[`UniqueComponent`](./index.html)`<`[`Group`](../../org.mechdancer.remote.resources/-group/index.html)`>` |
| [GroupMonitor](../../org.mechdancer.remote.modules.group/-group-monitor/index.html) | 组成员的管理器`class GroupMonitor : `[`UniqueComponent`](./index.html)`<`[`GroupMonitor`](../../org.mechdancer.remote.modules.group/-group-monitor/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [LongConnectionMonitor](../../org.mechdancer.remote.modules.tcpconnection/-long-connection-monitor/index.html) | 长连接管理（对等）`class LongConnectionMonitor : `[`UniqueComponent`](./index.html)`<`[`LongConnectionMonitor`](../../org.mechdancer.remote.modules.tcpconnection/-long-connection-monitor/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [LongConnectionSockets](../../org.mechdancer.remote.resources/-long-connection-sockets/index.html) | 长连接套接字`class LongConnectionSockets : `[`UniqueComponent`](./index.html)`<`[`LongConnectionSockets`](../../org.mechdancer.remote.resources/-long-connection-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |
| [MulticastBroadcaster](../../org.mechdancer.remote.modules.multicast/-multicast-broadcaster/index.html) | 组播发布者`class MulticastBroadcaster : `[`UniqueComponent`](./index.html)`<`[`MulticastBroadcaster`](../../org.mechdancer.remote.modules.multicast/-multicast-broadcaster/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [MulticastReceiver](../../org.mechdancer.remote.modules.multicast/-multicast-receiver/index.html) | 组播小包接收`class MulticastReceiver : `[`UniqueComponent`](./index.html)`<`[`MulticastReceiver`](../../org.mechdancer.remote.modules.multicast/-multicast-receiver/index.html)`>, `[`Dependent`](../-dependent/index.html) |
| [MulticastSockets](../../org.mechdancer.remote.resources/-multicast-sockets/index.html) | 组播套接字资源`class MulticastSockets : `[`UniqueComponent`](./index.html)`<`[`MulticastSockets`](../../org.mechdancer.remote.resources/-multicast-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |
| [Name](../../org.mechdancer.remote.resources/-name/index.html) | `class Name : `[`UniqueComponent`](./index.html)`<`[`Name`](../../org.mechdancer.remote.resources/-name/index.html)`>` |
| [Networks](../../org.mechdancer.remote.resources/-networks/index.html) | 网络端口扫描器`class Networks : `[`UniqueComponent`](./index.html)`<`[`Networks`](../../org.mechdancer.remote.resources/-networks/index.html)`>` |
| [PacketSlicer](../../org.mechdancer.remote.modules.multicast/-packet-slicer/index.html) | 数据包分片协议`class PacketSlicer : `[`UniqueComponent`](./index.html)`<`[`PacketSlicer`](../../org.mechdancer.remote.modules.multicast/-packet-slicer/index.html)`>, `[`Dependent`](../-dependent/index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [PortBroadcaster](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html) | 端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发`class PortBroadcaster : `[`UniqueComponent`](./index.html)`<`[`PortBroadcaster`](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html)`>, `[`Dependent`](../-dependent/index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [PortMonitor](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html) | 地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源`class PortMonitor : `[`UniqueComponent`](./index.html)`<`[`PortMonitor`](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html)`>, `[`Dependent`](../-dependent/index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [ScopeLogger](../../org.mechdancer.remote.modules/-scope-logger/index.html) | 域级日志器`class ScopeLogger : `[`UniqueComponent`](./index.html)`<`[`ScopeLogger`](../../org.mechdancer.remote.modules/-scope-logger/index.html)`>, Logger` |
| [ServerSockets](../../org.mechdancer.remote.resources/-server-sockets/index.html) | 监听套接字资源`class ServerSockets : `[`UniqueComponent`](./index.html)`<`[`ServerSockets`](../../org.mechdancer.remote.resources/-server-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |

