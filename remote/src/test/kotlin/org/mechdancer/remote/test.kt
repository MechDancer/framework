package org.mechdancer.remote

import org.mechdancer.remote.presets.RemoteDsl.Companion.remoteHub
import org.mechdancer.remote.protocol.writeEnd
import org.mechdancer.remote.resources.UdpCmd
import java.io.ByteArrayOutputStream
import java.io.DataOutputStream
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    val remote = remoteHub("kotlin topic server")
    remote.openAllNetworks()

    thread {
        while (true) {
            val x = 10 * Random.nextFloat()
            val y = 10 * Random.nextFloat()
            println("0 -> x: $x, y: $y")
            ByteArrayOutputStream()
                .apply {
                    writeEnd("sample0")
                    DataOutputStream(this).writeFloat(x)
                    DataOutputStream(this).writeFloat(y)
                }
                .toByteArray()
                .let { remote.broadcast(UdpCmd.TOPIC_MESSAGE, it) }
            Thread.sleep(1000)
        }
    }
}
