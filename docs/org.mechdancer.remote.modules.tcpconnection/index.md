---
title: org.mechdancer.remote.modules.tcpconnection - 
---

[org.mechdancer.remote.modules.tcpconnection](./index.html)

## Package org.mechdancer.remote.modules.tcpconnection

### Types

| [ConnectionClient](-connection-client/index.html) | `class ConnectionClient : UniqueComponent<`[`ConnectionClient`](-connection-client/index.html)`>, Dependent`<br>短连接客户端 |
| [ConnectionListener](-connection-listener/index.html) | `interface ConnectionListener : Component`<br>短连接监听者 |
| [ConnectionServer](-connection-server/index.html) | `class ConnectionServer : UniqueComponent<`[`ConnectionServer`](-connection-server/index.html)`>, Dependent`<br>TCP 连接服务器 |
| [LongConnectionMonitor](-long-connection-monitor/index.html) | `class LongConnectionMonitor : UniqueComponent<`[`LongConnectionMonitor`](-long-connection-monitor/index.html)`>, Dependent`<br>长连接管理（对等） |
| [MailListener](-mail-listener/index.html) | `interface MailListener : Component` |
| [PortBroadcaster](-port-broadcaster/index.html) | `class PortBroadcaster : UniqueComponent<`[`PortBroadcaster`](-port-broadcaster/index.html)`>, Dependent, `[`MulticastListener`](../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html)<br>端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发 |
| [PortMonitor](-port-monitor/index.html) | `class PortMonitor : UniqueComponent<`[`PortMonitor`](-port-monitor/index.html)`>, Dependent, `[`MulticastListener`](../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html)<br>地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源 |

### Extensions for External Classes

| [java.net.Socket](java.net.-socket/index.html) |  |

### Functions

| [connectionListener](connection-listener.html) | `fun connectionListener(interest: `[`Command`](../org.mechdancer.remote.resources/-command/index.html)` = TcpCmd.COMMON, block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, socket: `[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ConnectionListener`](-connection-listener/index.html)<br>构造 TCP 连接监听者 |
| [dialogListener](dialog-listener.html) | `fun dialogListener(block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ConnectionListener`](-connection-listener/index.html)<br>构造 TCP 对话监听者 |
| [mailListener](mail-listener.html) | `fun mailListener(block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MailListener`](-mail-listener/index.html)<br>构造 TCP 消息监听者 |

