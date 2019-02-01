package org.mechdancer.remote.presets

import org.mechdancer.dependency.Component
import org.slf4j.Logger

/** 远程终端构建器 */
class RemoteDsl internal constructor() {
    internal var loggerSetting: (Logger.() -> Unit)? = null
    internal var dependencies = mutableListOf<Component>()

    fun configLogger(block: Logger.() -> Unit) {
        loggerSetting = block
    }

    fun inAddition(block: () -> Component) {
        dependencies.add(block())
    }
}
