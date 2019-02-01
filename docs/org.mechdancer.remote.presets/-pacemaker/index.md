---
title: Pacemaker - 
---

[org.mechdancer.remote.presets](../index.html) / [Pacemaker](./index.html)

# Pacemaker

`class Pacemaker`

起搏器

为了兼顾灵活性与性能，建议使用起搏器打开网络端口。
使用方法：

1. 其他远程节点绑定所有本地网络接口，但不打开任何接口。
2. 构造起搏器，定时进行触发。
3. 收到起搏器激发包的远程节点将打开正确的网络接口。

### Parameters

`group` - 组播地址和端口

### Constructors

| [&lt;init&gt;](-init-.html) | `Pacemaker(group: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)`, loggerSetting: Logger.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)`<br>起搏器 |

### Properties

| [group](group.html) | `val group: `[`InetSocketAddress`](http://docs.oracle.com/javase/6/docs/api/java/net/InetSocketAddress.html)<br>组播地址和端口 |

### Functions

| [invoke](invoke.html) | `operator fun invoke(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>发送激发包 |
| [scan](scan.html) | `fun scan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>重新扫描并打开所有本地网络接口 |

