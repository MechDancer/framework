package org.mechdancer.remote

import org.mechdancer.common.extension.log4j.toConsole
import org.mechdancer.common.extension.log4j.toFile
import org.mechdancer.remote.presets.pacemaker

fun main() {
    pacemaker {
        toConsole()
        toFile()
    }
}
