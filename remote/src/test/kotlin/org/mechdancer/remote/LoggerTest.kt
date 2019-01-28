package org.mechdancer.remote

import org.apache.log4j.FileAppender
import org.apache.log4j.LogManager
import org.apache.log4j.PatternLayout
import org.slf4j.LoggerFactory

fun main() {
    val log = LoggerFactory.getLogger("abcde")
    val pattern = PatternLayout("")

    LogManager
        .getLogger(log.name)
        .addAppender(FileAppender(pattern, "${log.name}.txt"))

    log.debug("123455")
}
