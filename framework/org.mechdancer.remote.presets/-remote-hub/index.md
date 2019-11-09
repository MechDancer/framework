---
title: RemoteHub - framework
---

[framework](../../index.html) / [org.mechdancer.remote.presets](../index.html) / [RemoteHub](./index.html)

# RemoteHub

`class RemoteHub : `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

远程终端

### Types

| [RemoteInfo](-remote-info/index.html) | `data class RemoteInfo` |

### Constructors

| [&lt;init&gt;](-init-.html) | 远程终端`RemoteHub(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, group: `[`InetSocketAddress`](https://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`, sliceSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, loggerSetting: (Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?, additional: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`Component`](../../org.mechdancer.dependency/-component/index.html)`>)` |

### Properties

| [components](components.html) | 浏览全部依赖项`val components: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Component`](../../org.mechdancer.dependency/-component/index.html)`>` |

### Functions

| [accept](accept.html) | 阻塞等待 TCP 连接`fun accept(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ask](ask.html) | 主动询问一个远端的端口`infix fun ask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [askEveryone](ask-everyone.html) | 主动询问所有远端的端口`fun askEveryone(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [broadcast](broadcast.html) | 使用指令 [cmd](broadcast.html#org.mechdancer.remote.presets.RemoteHub$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/cmd) 广播数据包 [payload](broadcast.html#org.mechdancer.remote.presets.RemoteHub$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/payload)`fun broadcast(cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [close](close.html) | 关闭`fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [connect](connect.html) | 使用指令 [cmd](connect.html#org.mechdancer.remote.presets.RemoteHub$connect(kotlin.String, org.mechdancer.remote.resources.Command, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.connect.T)))/cmd) 连接到一个远端 [name](connect.html#org.mechdancer.remote.presets.RemoteHub$connect(kotlin.String, org.mechdancer.remote.resources.Command, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.connect.T)))/name)`fun <T> connect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, block: (`[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> T): T?` |
| [connectKeeping](connect-keeping.html) | 与 [name](connect-keeping.html#org.mechdancer.remote.presets.RemoteHub$connectKeeping(kotlin.String)/name) 建立长连接`fun connectKeeping(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [disconnect](disconnect.html) | 关闭与 [name](disconnect.html#org.mechdancer.remote.presets.RemoteHub$disconnect(kotlin.String)/name) 的长连接`fun disconnect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.html) | 查看超时时间 [timeout](get.html#org.mechdancer.remote.presets.RemoteHub$get(kotlin.Int)/timeout) 内出现的组成员`operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>查看远端 [name](get.html#org.mechdancer.remote.presets.RemoteHub$get(kotlin.String)/name) 的地址和端口`operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): RemoteInfo?` |
| [invoke](invoke.html) | 阻塞等待 UDP 报文`operator fun invoke(): `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`?` |
| [openAllNetworks](open-all-networks.html) | 尝试打开一个随机的网络端口，返回是否成功 若当前已有打开的网络端口则不进行任何操作`fun openAllNetworks(block: (`[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>打开所有网络端口，返回实际打开的网络端口数量`fun openAllNetworks(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [openFirstNetwork](open-first-network.html) | 尝试打开一个随机的网络端口，返回是否成功 若当前已有打开的网络端口则不进行任何操作`fun openFirstNetwork(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun openFirstNetwork(block: (`[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [processConnection](process-connection.html) | 使用与 [name](process-connection.html#org.mechdancer.remote.presets.RemoteHub$processConnection(kotlin.String, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.processConnection.T)))/name) 的连接`fun <T> processConnection(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: (`[`Socket`](https://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> T): T?` |
| [yell](yell.html) | 请求自证存在性`fun yell(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

