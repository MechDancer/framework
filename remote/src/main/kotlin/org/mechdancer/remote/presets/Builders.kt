package org.mechdancer.remote.presets

import org.slf4j.Logger
import java.net.InetAddress
import java.net.InetSocketAddress

private val GROUP =
    InetSocketAddress(
        InetAddress.getByAddress(byteArrayOf(233.toByte(), 33, 33, 33)),
        23333)

fun remoteHub(
    name: String? = null,
    address: InetSocketAddress = GROUP,
    sliceSize: Int = 0x4000,
    block: RemoteDsl.() -> Unit = {}
) = RemoteDsl()
    .apply(block)
    .let {
        RemoteHub(
            name,
            address,
            sliceSize,
            it.loggerSetting,
            it.dependencies
        )
    }

fun pacemaker(
    group: InetSocketAddress = GROUP,
    loggerSetting: (Logger.() -> Unit)? = null
) = Pacemaker(group, loggerSetting)

fun probe(
    group: InetSocketAddress = GROUP,
    loggerSetting: (Logger.() -> Unit)? = null
) = Probe(group, loggerSetting)
