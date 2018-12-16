package org.mechdancer.remote.protocol

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import kotlin.experimental.and

/**
 * 在流上编码变长整数
 * @param num 要编码的数字
 * @param signed 是否带符号编码
 * @return 流式操作，返回本身
 */
fun <T : OutputStream> T.zigzag(
    num: Long,
    signed: Boolean
): T {
    var temp =
        if (signed) (num shl 1) xor (num shr 63)
        else num

    while (true)
        if (temp > 0x7f) {
            write((temp or 0x80).toInt())
            temp = temp ushr 7
        } else {
            write(temp.toInt())
            return this
        }
}

/**
 * 在流上解码变长整数
 * @param signed 是否带符号解码
 * @return 数字
 */
fun InputStream.zigzag(signed: Boolean): Long {
    var offset = 0
    var result = 0L

    do {
        val b = read()
        result = result or ((b and 0x7f).toLong() shl 7 * offset++)
    } while (b > 0x7f)

    return if (signed) (result ushr 1) xor -(result and 1)
    else result
}

/**
 * 编码变长整数
 * @param signed 是否带符号编码
 * @return 编码
 */
fun Long.zigzag(signed: Boolean): ByteArray =
    ByteArrayOutputStream(10)
        .zigzag(this, signed)
        .toByteArray()

/**
 * 解码变长整数
 * @param signed 是否带符号解码
 * @return 数字
 */
fun ByteArray.zigzag(signed: Boolean): Long =
    foldRight(0L) { byte, acc ->
        acc shl 7 or ((byte and 0x7f).toLong())
    }.let {
        if (signed) (it ushr 1) xor -(it and 1)
        else it
    }
