package org.mechdancer.remote.protocol

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

/** 先将长度写入流，再将 [pack] 写入流 */
infix fun OutputStream.writeWithLength(pack: ByteArray) {
    zigzag(pack.size.toLong(), false)
    write(pack)
}

/** 先从流读出长度，再从流读出数据 */
fun InputStream.readWithLength(): ByteArray =
    waitNBytes(zigzag(false).toInt())

/**
 * 从输入流阻塞接收 [n] 个字节数据，或直到流关闭。
 * 函数会直接打开等于目标长度的缓冲区，因此不要用于实现尽量读取的功能。
 */
infix fun InputStream.waitNBytes(n: Int): ByteArray {
    val buffer = SimpleOutputStream(n)
    for (i in 0 until n)
        read().takeIf { it in 0..255 }
            ?.also(buffer::write)
            ?: return buffer.core.copyOfRange(0, i)
    return buffer.core
}

/** 向流写入 [string]，再写入结尾 */
fun OutputStream.writeEnd(string: String) =
    apply {
        write(string.toByteArray())
        write(0)
    }

/** 从流读取一个带结尾的字符串 */
fun InputStream.readEnd(): String {
    val buffer = ByteArrayOutputStream()
    while (true)
        when (val temp = read()) {
            -1, 0 -> return String(buffer.toByteArray())
            else  -> buffer.write(temp)
        }
}
