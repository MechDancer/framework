package org.mechdancer.remote

import org.mechdancer.common.extension.log4j.loggerWrapper
import org.mechdancer.remote.presets.pacemaker

fun main() {
    pacemaker {
        loggerWrapper {
            console()
            file()
        }(this)
    }
}
