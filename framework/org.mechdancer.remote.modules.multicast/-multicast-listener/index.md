---
title: MulticastListener - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.multicast](../index.html) / [MulticastListener](./index.html)

# MulticastListener

`interface MulticastListener : `[`Component`](../../org.mechdancer.dependency/-component/index.html)

组播监听者

### Properties

| [interest](interest.html) | `abstract val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`>` |

### Functions

| [process](process.html) | `abstract infix fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [PacketSlicer](../-packet-slicer/index.html) | 数据包分片协议`class PacketSlicer : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`PacketSlicer`](../-packet-slicer/index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](./index.html) |
| [PortBroadcaster](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html) | 端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发`class PortBroadcaster : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`PortBroadcaster`](../../org.mechdancer.remote.modules.tcpconnection/-port-broadcaster/index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](./index.html) |
| [PortMonitor](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html) | 地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源`class PortMonitor : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`PortMonitor`](../../org.mechdancer.remote.modules.tcpconnection/-port-monitor/index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](./index.html) |

