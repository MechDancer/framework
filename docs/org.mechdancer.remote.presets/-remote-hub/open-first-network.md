---
title: RemoteHub.openFirstNetwork - 
---

[org.mechdancer.remote.presets](../index.html) / [RemoteHub](index.html) / [openFirstNetwork](./open-first-network.html)

# openFirstNetwork

`fun openFirstNetwork(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)
`fun openFirstNetwork(block: (`[`NetworkInterface`](http://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

尝试打开一个随机的网络端口，返回是否成功
若当前已有打开的网络端口则不进行任何操作

