package org.mechdancer.remote.presets

import org.mechdancer.dependency.Component
import org.slf4j.Logger
import java.net.InetSocketAddress

/** 远程终端构建器 */
class RemoteDsl private constructor() {
    private var newMemberDetected: (String) -> Unit = {}
    private var dependencies = mutableListOf<Component>()

    fun newMemberDetected(block: (String) -> Unit) {
        newMemberDetected = block
    }

    fun inAddition(block: () -> Component) {
        dependencies.add(block())
    }

    companion object {
        fun remoteHub(
            name: String? = null,
            address: InetSocketAddress = Default.GROUP,
            loggerSetting: Logger.() -> Unit = Default.LOGGER_SETTING,
            sliceSize: Int = 0x4000,
            block: RemoteDsl.() -> Unit = {}
        ) = RemoteDsl()
            .apply(block)
            .let {
                RemoteHub(
                    name,
                    address,
                    sliceSize,
                    loggerSetting,
                    it.newMemberDetected,
                    it.dependencies
                )
            }
    }
}
