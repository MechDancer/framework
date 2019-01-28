package org.mechdancer.remote.presets

import org.mechdancer.dependency.Component
import org.mechdancer.dependency.DynamicScope
import org.mechdancer.remote.resources.LoggerSetting
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 安装日志器
 */
fun DynamicScope.setupLogger(
    name: String,
    setting: (Logger) -> Unit
): Logger {
    val result = LoggerFactory.getLogger(name).apply(setting)
    setup(LoggerSetting(setting))
    setup(object : Component, Logger by result {
        override fun equals(other: Any?) = other is Logger
        override fun hashCode() = name.hashCode()
    })
    return result
}
