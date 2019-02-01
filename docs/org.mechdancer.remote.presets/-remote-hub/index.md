---
title: RemoteHub - 
---

[org.mechdancer.remote.presets](../index.html) / [RemoteHub](./index.html)

# RemoteHub

`class RemoteHub : `[`Closeable`](http://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html)

远程终端

### Types

| [RemoteInfo](-remote-info/index.html) | `data class RemoteInfo` |

### Constructors

| [&lt;init&gt;](-init-.html) | `RemoteHub(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, group: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`, sliceSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, loggerSetting: Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, additional: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<Component>)`<br>远程终端 |

### Properties

| [components](components.html) | `val components: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<Component>`<br>浏览全部依赖项 |

### Functions

| [accept](accept.html) | `fun accept(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>阻塞等待 TCP 连接 |
| [ask](ask.html) | `infix fun ask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>主动询问一个远端的端口 |
| [askEveryone](ask-everyone.html) | `fun askEveryone(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>主动询问所有远端的端口 |
| [broadcast](broadcast.html) | `fun broadcast(cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, payload: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>使用指令 [cmd](broadcast.html#org.mechdancer.remote.presets.RemoteHub$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/cmd) 广播数据包 [payload](broadcast.html#org.mechdancer.remote.presets.RemoteHub$broadcast(org.mechdancer.remote.resources.Command, kotlin.ByteArray)/payload) |
| [close](close.html) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>关闭 |
| [connect](connect.html) | `fun <T> connect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, cmd: `[`Command`](../../org.mechdancer.remote.resources/-command/index.html)`, block: (`[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> `[`T`](connect.html#T)`): `[`T`](connect.html#T)`?`<br>使用指令 [cmd](connect.html#org.mechdancer.remote.presets.RemoteHub$connect(kotlin.String, org.mechdancer.remote.resources.Command, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.connect.T)))/cmd) 连接到一个远端 [name](connect.html#org.mechdancer.remote.presets.RemoteHub$connect(kotlin.String, org.mechdancer.remote.resources.Command, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.connect.T)))/name) |
| [connectKeeping](connect-keeping.html) | `fun connectKeeping(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>与 [name](connect-keeping.html#org.mechdancer.remote.presets.RemoteHub$connectKeeping(kotlin.String)/name) 建立长连接 |
| [disconnect](disconnect.html) | `fun disconnect(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>关闭与 [name](disconnect.html#org.mechdancer.remote.presets.RemoteHub$disconnect(kotlin.String)/name) 的长连接 |
| [get](get.html) | `operator fun get(timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>查看超时时间 [timeout](get.html#org.mechdancer.remote.presets.RemoteHub$get(kotlin.Int)/timeout) 内出现的组成员`operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RemoteInfo`](-remote-info/index.html)`?`<br>查看远端 [name](get.html#org.mechdancer.remote.presets.RemoteHub$get(kotlin.String)/name) 的地址和端口 |
| [invoke](invoke.html) | `operator fun invoke(): `[`RemotePacket`](../../org.mechdancer.remote.protocol/-remote-packet/index.html)`?`<br>阻塞等待 UDP 报文 |
| [openAllNetworks](open-all-networks.html) | `fun openAllNetworks(block: (`[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>尝试打开一个随机的网络端口，返回是否成功 若当前已有打开的网络端口则不进行任何操作`fun openAllNetworks(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>打开所有网络端口，返回实际打开的网络端口数量 |
| [openFirstNetwork](open-first-network.html) | `fun openFirstNetwork(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun openFirstNetwork(block: (`[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>尝试打开一个随机的网络端口，返回是否成功 若当前已有打开的网络端口则不进行任何操作 |
| [processConnection](process-connection.html) | `fun <T> processConnection(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: (`[`Socket`](http://docs.oracle.com/javase/6/docs/api/java/net/Socket.html)`) -> `[`T`](process-connection.html#T)`): `[`T`](process-connection.html#T)`?`<br>使用与 [name](process-connection.html#org.mechdancer.remote.presets.RemoteHub$processConnection(kotlin.String, kotlin.Function1((java.net.Socket, org.mechdancer.remote.presets.RemoteHub.processConnection.T)))/name) 的连接 |
| [yell](yell.html) | `fun yell(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>请求自证存在性 |

