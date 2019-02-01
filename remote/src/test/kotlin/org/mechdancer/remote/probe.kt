package org.mechdancer.remote

import org.mechdancer.remote.presets.probe
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

fun main() {
    val probe = probe()
    thread { while (true) probe() }
    while (true) {
        readLine()
        println(format(System.currentTimeMillis()))
        for ((name, info) in probe.view) {
            val (time, address) = info
            println("$name: ${format(time)}, $address")
        }
        println("___")
    }
}

private fun format(time: Long) =
    SimpleDateFormat("HH:mm:ss:SSS").format(Date(time))
