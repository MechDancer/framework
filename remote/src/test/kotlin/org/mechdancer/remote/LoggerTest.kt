package org.mechdancer.remote

import org.apache.log4j.ConsoleAppender
import org.apache.log4j.FileAppender
import org.apache.log4j.LogManager
import org.apache.log4j.PatternLayout
import org.mechdancer.remote.presets.pacemaker
import org.slf4j.Logger
import java.io.File
import java.nio.file.Path
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

// 日志文件夹路径
private val DefaultPath = System.getProperty("user.dir")

// 日志模板组件
const val PatternHeader = "[%p]\t%d{HH:mm:ss:SSS}"
const val Message = "%m"
const val Stamp = "%r"
const val Locate = "%l"

/** 构造一个模式 */
fun pattern(vararg topics: String) =
    PatternLayout("$PatternHeader\t${topics.joinToString("\t")}%n")

/** 默认模式 */
val DefaultLayout = pattern(Message)

/** 在log4j中获取日志器 */
val Logger.underlying: org.apache.log4j.Logger
    get() = LogManager.getLogger(name)

/** 设置日志输出到控制台 */
fun Logger.toConsole() =
    underlying.addAppender(ConsoleAppender(DefaultLayout))

/** 设置日志输出到文件 */
fun Logger.toFile(period: Int = 0x100000) =
    underlying.addAppender(
        FileAppender(DefaultLayout,
                     "$currentLogPath\\$name",
                     false,
                     true,
                     period))

/** 读取/设置日志级别 */
var Logger.level
    get() = underlying.level!!
    set(value) {
        underlying.level = value
    }

// 运行目录下创建log文件夹
private val logPath: String by lazy {
    File(DefaultPath, "log")
        .also { if (!it.exists()) it.mkdir() }
        .toPath()
        .toString()
}

// log文件夹下创建本次运行的文件夹
private val currentLogPath: Path by lazy {
    // 创建文件夹 => 创建了文件 => 需要保证全部输出
    Runtime
        .getRuntime()
        .addShutdownHook(thread(start = false) { LogManager.shutdown() })
    // 创建文件夹
    File(logPath, SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Date()))
        .also { if (!it.exists()) it.mkdir() }
        .toPath()
}

fun main() {
    pacemaker {
        toConsole()
        toFile()
    }
}
