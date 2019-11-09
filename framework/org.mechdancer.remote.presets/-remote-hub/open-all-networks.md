---
title: RemoteHub.openAllNetworks - framework
---

[framework](../../index.html) / [org.mechdancer.remote.presets](../index.html) / [RemoteHub](index.html) / [openAllNetworks](./open-all-networks.html)

# openAllNetworks

`fun openAllNetworks(block: (`[`NetworkInterface`](https://docs.oracle.com/javase/6/docs/api/java/net/NetworkInterface.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

尝试打开一个随机的网络端口，返回是否成功
若当前已有打开的网络端口则不进行任何操作

`fun openAllNetworks(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

打开所有网络端口，返回实际打开的网络端口数量

