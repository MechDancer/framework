package org.mechdancer.remote.modules

import org.mechdancer.dependency.UniqueComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 域级日志器
 */
class ScopeLogger(
    name: String,
    setting: Logger.() -> Unit
) : UniqueComponent<ScopeLogger>(),
    Logger by LoggerFactory.getLogger(name) {
    init {
        setting()
        info("initialized")
    }
}
