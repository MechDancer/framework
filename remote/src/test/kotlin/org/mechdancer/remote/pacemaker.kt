package org.mechdancer.remote

import org.mechdancer.remote.presets.Pacemaker

fun main() {
    val pacemaker = Pacemaker { toConsole() }
    while (true) {
        pacemaker()
        Thread.sleep(1000)
    }
}
