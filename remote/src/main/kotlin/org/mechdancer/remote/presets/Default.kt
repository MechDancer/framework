package org.mechdancer.remote.presets

import java.net.InetAddress
import java.net.InetSocketAddress

internal object Default {
    val GROUP = InetSocketAddress(InetAddress.getByAddress(byteArrayOf(233.toByte(), 33, 33, 33)), 23333)
}