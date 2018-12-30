package org.mechdancer.remote

import org.mechdancer.remote.presets.Probe
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

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