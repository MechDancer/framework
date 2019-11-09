---
title: org.mechdancer.remote.modules.tcpconnection - framework
---

[framework](../index.html) / [org.mechdancer.remote.modules.tcpconnection](./index.html)

## Package org.mechdancer.remote.modules.tcpconnection

### Types

| [ConnectionClient](-connection-client/index.html) | 短连接客户端`class ConnectionClient : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`ConnectionClient`](-connection-client/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html) |
| [ConnectionListener](-connection-listener/index.html) | 短连接监听者`interface ConnectionListener : `[`Component`](../org.mechdancer.dependency/-component/index.html) |
| [ConnectionServer](-connection-server/index.html) | TCP 连接服务器`class ConnectionServer : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`ConnectionServer`](-connection-server/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html) |
| [LongConnectionMonitor](-long-connection-monitor/index.html) | 长连接管理（对等）`class LongConnectionMonitor : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`LongConnectionMonitor`](-long-connection-monitor/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html) |
| [MailListener](-mail-listener/index.html) | `interface MailListener : `[`Component`](../org.mechdancer.dependency/-component/index.html) |
| [PortBroadcaster](-port-broadcaster/index.html) | 端口同步机制 2 这个模块用于 TCP 连接的接收者 因此必须具备有效的 TCP 监听套接字和名字，并依赖组播收发`class PortBroadcaster : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`PortBroadcaster`](-port-broadcaster/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |
| [PortMonitor](-port-monitor/index.html) | 地址同步机制 1 这个模块用于 TCP 连接的发起者 依赖地址资源和组播收发功能 将发起地址询问并更新地址资源`class PortMonitor : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`PortMonitor`](-port-monitor/index.html)`>, `[`Dependent`](../org.mechdancer.dependency/-dependent/index.html)`, `[`MulticastListener`](../org.mechdancer.remote.modules.multicast/-multicast-listener/index.html) |

### Extensions for External Classes

| [java.net.Socket](java.net.-socket/index.html) |  |

### Functions

| [connectionListener](connection-listener.html) | 构造 TCP 连接监听者`fun connectionListener(interest: `[`Command`](../org.mechdancer.remote.resources/-command/index.html)` = TcpCmd.COMMON, block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, socket: `[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ConnectionListener`](-connection-listener/index.html) |
| [dialogListener](dialog-listener.html) | 构造 TCP 对话监听者`fun dialogListener(block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`ConnectionListener`](-connection-listener/index.html) |
| [mailListener](mail-listener.html) | 构造 TCP 消息监听者`fun mailListener(block: (client: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MailListener`](-mail-listener/index.html) |

