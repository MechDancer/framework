# 远程接入协议

[![Download](https://api.bintray.com/packages/mechdancer/maven/remote/images/download.svg)](https://bintray.com/mechdancer/maven/remote/_latestVersion)[![Build Status](https://travis-ci.com/MechDancer/remote.svg?branch=master)](https://travis-ci.com/MechDancer/remote)

## 设计思路

本协议框架由 3 部分组成：

* 成员发现和地址同步
* 不可靠的数据广播和可靠的点对点数据传输
* 基于插件的各类附加功能

其中指令传输采用 2 种方式：

* udp 组播：传递内部指令、进程信息和用户广播报文，承载基于广播的插件服务
* tcp：传递有可靠性要求的用户报文、实现远程调用，承载点对点的插件服务

## 使用说明

1. 构造

   要使用远程服务，首先必须构造承载远程服务的**终端**`RemoteHub`。 

   尽管我们也不反对直接通过构造器构造，但对于 kotlin 的使用者来说，强烈建议使用 DSL 来构造（或者说 *配置* ）终端。

   下面一段代码说明了配置终端的方法和各种可选项。

   ```kotlin
   remoteHub(name = "Hub") {
       newMemberDetected = ::println
   	    broadcastReceived = { name, msg -> println("$name: ${String(msg)}") }
   	    commandReceived = { name, ask ->
   	        String(ask)
   		        .also { println("$name: \"$it\"") }
   		        .let { "ok: $it" }
   		        .toByteArray()
           }
   }
   ```

   其中展示的所有自定义内容都是可选的，下面是详细的说明：

   1. 名字 `name`

      终端的名字是终端在网络中的唯一标识，因此用户有义务在线下保证名字的**唯一性**。不具名的终端将获得默认的名字，形式为`Hub[${IP地址}:${端口号}]`，假如相继启动多个终端过程中主机网络情况不变，同一台主机上启动的终端会获得相同的IP地址和不同的端口号；同一局域网中不同主机上的终端IP地址则一定不同。

      点对点通信过程中需要以名字为引导，因此要作为点对点通信服务方的终端必须具名。

   2. 服务发现 `newMemberDetected`

      当终端发现新成员出现在网络中，将触发服务发现回调。回调的参数为新成员的名字。

   3. 收到通用广播 `broadcastReceived`

      回调的参数为收到广播的发送者名字和数据报，并可通过 `this` 访问终端，就如同编写终端的成员函数一样。但要在回调内使用终端功能，请注意回调调用期间终端的接收函数是阻塞的，因此无法在此线程中继续提供服务。

   4. 收到通用单播 `commandReceived`

      收到 TCP 报文时调用。应提供 ByteArray 类型的返回值，要求返回的调用方将收到此数组作为调用的结果。其他与广播类似。

2. 启动服务

   处于纯粹性考虑，框架不提供任何调度功能，所有阻塞操作完全由用户控制。

   目前已提供 3 种服务：

   1. UDP 解析和处理 `invoke`

      由于很多内核功能也由此方法承担，因此建议在启用其他功能前先启动此方法，并在终端的整个工作周期里反复调用。

   2. TCP 解析和处理 `listen`

   3. 刷新组成员列表 `refresh(timeout)`

3. 发送

   使用 `broadcast` 方法发送 UDP 组播。

   使用 `send` 方法发送 TCP 单播。

   使用 `call` 方法发送 TCP 单播，并阻塞以取得回复。

4. 插件

   插件是一些预置的处理机制或者服务，可以预先进行严格而独立的封装。插件通过**识别号**`id`来分别。id是一个字符`Char`，只能是字母或数字，大小写敏感，因此最多加载 26 × 2 + 10 = 62 个。

   插件支持在构造时置入，也可以在运行间动态加载。

   ```kotlin
   // 配置插件
   remoteHub {
       plugins {
   	    topicReceiver { sender, topic, data ->
   	        println("$sender($topic): $data")
           }
       }
   }
   // 动态加载
   remoteHub() setup ReceivePlugin { sender, topic, data ->
       println("$sender($topic): $data")
   }
   ```
   
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
    compile 'org.mechdancer:remote:+'
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
  <version>LATEST</version>
  <type>pom</type>
</dependency>
```

### Bintray

您总可以从 bintray 直接下载 jar： [![Download](https://api.bintray.com/packages/mechdancer/maven/remote/images/download.svg)](https://bintray.com/mechdancer/maven/remote/_latestVersion)
