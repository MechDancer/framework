package org.mechdancer.remote

import org.mechdancer.remote.presets.pacemaker

fun main() {
    val pacemaker = pacemaker()
    while (true) {
        pacemaker()
        Thread.sleep(1000)
    }
}
