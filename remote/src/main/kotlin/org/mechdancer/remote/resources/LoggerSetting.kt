package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.slf4j.Logger

/**
 * 日志配置器
 */
class LoggerSetting(val setting: (logger: Logger) -> Unit)
    : UniqueComponent<LoggerSetting>()
