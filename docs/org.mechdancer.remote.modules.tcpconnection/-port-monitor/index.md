---
title: PortMonitor - 
---

[org.mechdancer.remote.modules.tcpconnection](../index.html) / [PortMonitor](./index.html)

# PortMonitor

`class PortMonitor : UniqueComponent<`[`PortMonitor`](./index.html)`>, Dependent, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html)

地址同步机制 1
这个模块用于 TCP 连接的发起者
依赖地址资源和组播收发功能
将发起地址询问并更新地址资源

### Constructors

| [&lt;init&gt;](-init-.html) | `PortMonitor()`<br>地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源 |

### Properties

| [interest](interest.html) | `val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`UdpCmd`](../../org.mechdancer.remote.resources/-udp-cmd/index.html)`>` |

### Functions

| [ask](ask.html) | `fun ask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>向一个名为 [name](ask.html#org.mechdancer.remote.modules.tcpconnection.PortMonitor$ask(kotlin.String)/name) 的远端发送端口询问 |
| [askEveryone](ask-everyone.html) | `fun askEveryone(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>向所有远端发送端口询问 |
| [process](process.html) | `fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | `fun sync(dependency: Component): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

