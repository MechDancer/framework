---
title: Dependent - framework
---

[framework](../../index.html) / [org.mechdancer.dependency](../index.html) / [Dependent](./index.html)

# Dependent

`interface Dependent : `[`Component`](../-component/index.html)

依赖者

依赖者的内容不完整，需要获得依赖项的支持
因此当一个新的依赖项到达，依赖者会得到通知，直到所有依赖项都集齐为止

### Functions

| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`abstract fun sync(dependency: `[`Component`](../-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| [ConnectionClient](../../org.mechdancer.remote.modules.tcpconnection/-connection-client/index.html) | 短连接客户端`class ConnectionClient : `[`UniqueComponent`](../-unique-component/index.html)`<`[`ConnectionClient`](../../org.mechdancer.remote.modules.tcpconnection/-connection-client/index.html)`>, `[`Dependent`](./index.html) |
| [ConnectionServer](../../org.mechdancer.remote.modules.tcpconnection/-connection-server/index.html) | TCP 连接服务器`class ConnectionServer : `[`UniqueComponent`](../-unique-component/index.html)`<`[`ConnectionServer`](../../org.mechdancer.remote.modules.tcpconnection/-connection-server/index.html)`>, `[`Dependent`](./index.html) |
| [GroupMonitor](../../org.mechdancer.remote.modules.group/-group-monitor/index.html) | 组成员的管理器`class GroupMonitor : `[`UniqueComponent`](../-unique-component/index.html)`<`[`GroupMonitor`](../../org.mechdancer.remote.modules.group/-group-monitor/index.html)`>, `[`Dependent`](./index.html) |
| [LongConnectionMonitor](../../org.mechdancer.remote.modules.tcpconnection/-long-connection-monitor/index.html) | 长连接管理（对等）`class LongConnectionMonitor : `[`UniqueComponent`](../-unique-component/index.html)`<`[`LongConnectionMonitor`](../../org.mechdancer.remote.modules.tcpconnection/-long-connection-monitor/index.html)`>, `[`Dependent`](./index.html) |
| [MulticastBroadcaster](../../org.mechdancer.remote.modules.multicast/-multicast-broadcaster/index.html) | 组播发布者`class MulticastBroadcaster : `[`UniqueComponent`](../-unique-component/index.html)`<`[`MulticastBroadcaster`](../../org.mechdancer.remote.modules.multicast/-multicast-broadcaster/index.html)`>, `[`Dependent`](./index.html) |
| [MulticastReceiver](../../org.mechdancer.remote.modules.multicast/-multicast-receiver/index.html) | 组播小包接收`class MulticastReceiver : `[`UniqueComponent`](../-unique-component/index.html)`<`[`MulticastReceiver`](../../org.mechdancer.remote.modules.multicast/-multicast-receiver/index.html)`>, `[`Dependent`](./index.html) |
| [PacketSlicer](../../org.mechdancer.remote.modules.multicast/-packet-slicer/index.html) | 数据包分片协议`class PacketSlicer : `[`UniqueComponent`](../-unique-component/index.html)`<`[`PacketSlicer`](../../org.mechdancer.remote.modules.multicast/-packet-slicer/index.html)`>, `[`Dependent`](./index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [PortBroadcaster](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html) | 端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发`class PortBroadcaster : `[`UniqueComponent`](../-unique-component/index.html)`<`[`PortBroadcaster`](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html)`>, `[`Dependent`](./index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [PortMonitor](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html) | 地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源`class PortMonitor : `[`UniqueComponent`](../-unique-component/index.html)`<`[`PortMonitor`](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html)`>, `[`Dependent`](./index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |

