---
title: PortBroadcaster - 
---

[org.mechdancer.remote.modules.tcpconnection](../index.html) / [PortBroadcaster](./index.html)

# PortBroadcaster

`class PortBroadcaster : UniqueComponent<`[`PortBroadcaster`](./index.html)`>, Dependent, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html)

端口同步机制 2
这个模块用于 TCP 连接的接收者
因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发

### Constructors

| [&lt;init&gt;](-init-.html) | `PortBroadcaster()`<br>端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发 |

### Properties

| [interest](interest.html) | `val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`UdpCmd`](../../org.mechdancer.remote.resources/-udp-cmd/index.html)`>` |

### Functions

| [process](process.html) | `fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

