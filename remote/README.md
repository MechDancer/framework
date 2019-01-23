# 远程接入协议库

[![Download](https://api.bintray.com/packages/mechdancer/maven/remote/images/download.svg)](https://bintray.com/mechdancer/maven/remote/_latestVersion)

## 概述

 简易网络库

本网络库是对 Raw Socket 包含少量自定义协议的封装，提供成员发现、地址同步、组播收发和TCP连接建立等功能。

## 设计思路

本协议框架由 3 部分组成：

* 成员发现和地址同步
* 不可靠的数据广播和可靠连接的建立
* 供开发者扩展自定义功能的接口

内部实现基于 [dependency](../dependency) 提供的依赖项管理功能组织各个功能模块。

### 结构

本网络库主要提供局域网内连接和通信功能，因此大部分工作通过局域网组播实现。其中各个组件通过 dependency 定义的 `DynamicScope` 联系起来，因此不一定能够独立工作，但总的来说分为 2 种：

* 资源 `Resources`

  资源的概念类似于全局变量，是所有功能模块行使功能所共同依赖的信息或系统资源，包括套接字、本地网络环境和组成员地址等。

  资源必定不依赖其他组件，因此可以不在域中使用。

* 功能模块 `Modules`

  功能模块主要封装了协议、算法等，可能还包含私有的状态信息。

  许多功能模块包含严格的组件依赖，因此无法在域外使用。

## 使用

要使用库提供的功能，开发者可以自己构造一个动态域，并添加需要的功能模块，但这可能需要对组件依赖关系非常熟悉。因此我们推荐使用预先构建的常用组件集，其中已经包含完成特定功能所需的组件，并将一些组件功能封装成了更容易调用的方法。

下面针对基于组播通信的流程介绍一些预置组件集。

#### step1 打开

要进行组播通信，发送方和接收方很可能是不对等的。由于组播地址和单播地址是并列的，而广播地址（或者说子网地址）是基于单播地址，因此与广播不同，组播必须指定从从哪个网络接口发送。想要向多个局域网发送则必须打开多个发送套接字（或每次发送时修改套接字的网络接口，可能存在性能问题且多线程下需要同步，因此没有这样使用）。

若用户有多个网卡、连接到多个局域网，又对局域网没有认识，可能不知道应该打开哪些接口。对于接收的情况比较简单，即使多绑定了，只要没有相同组播地址和端口的数据到来就没有性能损耗，可以直接监听本机的所有网络接口，但发送方若打开了无用的网络接口将导致发送的耗时成倍增加。此时比较方便的方案是使用*起搏器*  `Pacemaker`。

起搏器包含了本地网络扫描和组播发送的组件。构造时，将扫描本地网卡情况并打开与网络接口数量相同的套接字用于向所有网络接口发送。因此可以在组中某个节点所在的设备上打开一个起搏器，并通过起搏器定时发送激发包。其他节点启动时只要监听所有网络接口，就能在正确的网络接口上收到激发包，再打开激发包来自的子网接口即可。

启动起搏器的代码范例如下：

```kotlin
fun main() {
    val pacemaker = Pacemaker()
    while (true) {
        pacemaker()
        Thread.sleep(1000)
    }
}
```

所有目标节点都上线之后，可以关闭起搏器。

#### step2 诊断

要查看组中已经上线的节点，我们推荐使用*探针* `Probe`。探针包含了所有节点信息的接收和存储功能，能查看最后出现时间、IP 地址和 TCP Server 端口。由于只查看不发送，不会影响其他节点，使用也没什么要求。

```kotlin
fun main() {
    val probe = Probe()
    thread { while (true) probe() }

    while (true) {
        readLine()
        println(SimpleDateFormat("HH:mm:ss:SSS").format(Date()))
        for ((name, info) in probe.view) {
            val (time, address) = info
            println("$name: $time, $address")
        }
        println("___")
    }
}
```

#### step3 使用

要使用网络库的全部功能，我们推荐包含了所有组件的 `RemoteHub` 类。

## 开始使用

* Gradle
* Maven
* Bintray

您需要将其添加至  [仓库和依赖](https://docs.gradle.org/current/userguide/declaring_dependencies.html) 中。

### Gradle

```groovy
repositories {
    jcenter()
}
dependencies {
    compile 'org.mechdancer:remote:0.2.1-dev-10'
}
```

### Maven

```xml
<repositories>
   <repository>
     <id>jcenter</id>
     <name>JCenter</name>
     <url>https://jcenter.bintray.com/</url>
   </repository>
</repositories>

<dependency>
  <groupId>org.mechdancer</groupId>
  <artifactId>remote</artifactId>
  <version>0.2.1-dev-10</version>
  <type>pom</type>
</dependency>
```

### Bintray

您总可以从 bintray 直接下载 jar： [![Download](https://api.bintray.com/packages/mechdancer/maven/remote/images/download.svg)](https://bintray.com/mechdancer/maven/remote/_latestVersion)
