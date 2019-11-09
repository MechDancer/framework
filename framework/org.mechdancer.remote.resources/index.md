---
title: org.mechdancer.remote.resources - framework
---

[framework](../index.html) / [org.mechdancer.remote.resources](./index.html)

## Package org.mechdancer.remote.resources

### Types

| [Addresses](-addresses/index.html) | 地址资源`class Addresses : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`Addresses`](-addresses/index.html)`>` |
| [Command](-command/index.html) | 命令接口`interface Command` |
| [Group](-group/index.html) | 成员存在性资源`class Group : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`Group`](-group/index.html)`>` |
| [LongConnectionSockets](-long-connection-sockets/index.html) | 长连接套接字`class LongConnectionSockets : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`LongConnectionSockets`](-long-connection-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |
| [MulticastSockets](-multicast-sockets/index.html) | 组播套接字资源`class MulticastSockets : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`MulticastSockets`](-multicast-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |
| [Name](-name/index.html) | `class Name : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`Name`](-name/index.html)`>` |
| [Networks](-networks/index.html) | 网络端口扫描器`class Networks : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`Networks`](-networks/index.html)`>` |
| [ServerSockets](-server-sockets/index.html) | 监听套接字资源`class ServerSockets : `[`UniqueComponent`](../org.mechdancer.dependency/-unique-component/index.html)`<`[`ServerSockets`](-server-sockets/index.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |
| [TcpCmd](-tcp-cmd/index.html) | TCP 协议指令`enum class TcpCmd : `[`Command`](-command/index.html) |
| [TcpFeedbackCmd](-tcp-feedback-cmd/index.html) | `enum class TcpFeedbackCmd : `[`Command`](-command/index.html) |
| [UdpCmd](-udp-cmd/index.html) | 组播协议`enum class UdpCmd : `[`Command`](-command/index.html) |

