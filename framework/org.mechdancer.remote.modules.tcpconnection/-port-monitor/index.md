---
title: PortMonitor - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.tcpconnection](../index.html) / [PortMonitor](./index.html)

# PortMonitor

`class PortMonitor : `[`UniqueComponent`](../../org.mechdancer.dependency/-unique-component/index.html)`<`[`PortMonitor`](./index.html)`>, `[`Dependent`](../../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](../../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html)

地址同步机制 1
这个模块用于 TCP 连接的发起者
依赖地址资源和组播收发功能
将发起地址询问并更新地址资源

### Constructors

| [&lt;init&gt;](-init-.html) | 地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源`PortMonitor()` |

### Properties

| [interest](interest.html) | `val interest: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`UdpCmd`](../../org.mechdancer.remote.resources/-udp-cmd/index.html)`>` |

### Functions

| [ask](ask.html) | 向一个名为 [name](ask.html#org.mechdancer.remote.modules.tcpconnection.PortMonitor$ask(kotlin.String)/name) 的远端发送端口询问`fun ask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [askEveryone](ask-everyone.html) | 向所有远端发送端口询问`fun askEveryone(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [process](process.html) | `fun process(remotePacket: `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sync](sync.html) | 向依赖者展示新的依赖项[dependency](../../org.mechdancer.dependency/-dependent/sync.html#org.mechdancer.dependency.Dependent$sync(org.mechdancer.dependency.Component)/dependency)，并返回是否已获得全部依赖项`fun sync(dependency: `[`Component`](../../org.mechdancer.dependency/-component/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

