package org.mechdancer.remote

import org.apache.log4j.ConsoleAppender
import org.apache.log4j.FileAppender
import org.apache.log4j.LogManager
import org.apache.log4j.PatternLayout
import org.mechdancer.remote.presets.Pacemaker
import org.slf4j.Logger
import java.io.File
import java.nio.file.Path
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

// 日志文件夹路径
private val DefaultPath = System.getProperty("user.dir")

// 日志行模板
private val DefaultLayout = PatternLayout("[%-5p]\t%d{HH:mm:ss:SSS}\t%l\t%m%n")

/** 设置日志输出到控制台 */
fun Logger.toConsole() =
    apply { LogManager.getLogger(name).addAppender(ConsoleAppender(DefaultLayout)) }

/** 设置日志输出到文件 */
fun Logger.toFile(period: Int = 0x100000) =
    apply {
        LogManager
            .getLogger(name)
            .addAppender(
                FileAppender(DefaultLayout,
                             "$currentLogPath\\$name",
                             false,
                             true,
                             period))
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
    Pacemaker {
        toConsole()
        toFile()
    }
}
