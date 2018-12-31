package org.mechdancer.encoder.core.data

import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.writeEnd
import org.mechdancer.encoder.util.zigzag
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStream
import java.io.OutputStream

internal class Tool(
    val encoder: (OutputStream, Any) -> Unit,
    val decoder: (InputStream) -> Any
)

internal val basic = mapOf(
    "i1" to Tool(::ei1, ::di1),
    "i2" to Tool(::ei2, ::di2),
    "i4" to Tool(::ei4, ::di4),
    "i8" to Tool(::ei8, ::di8),
    "uv" to Tool(::euv, ::duv),
    "iv" to Tool(::eiv, ::div),
    "f4" to Tool(::ef4, ::df4),
    "f8" to Tool(::ef8, ::df8),
    "s" to Tool(::es, ::ds)
)

private fun ei1(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeByte((value as Number).toInt())

private fun ei2(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeShort((value as Number).toInt())

private fun ei4(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeInt(value as Int)

private fun ei8(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeLong(value as Long)

private fun euv(stream: OutputStream, value: Any) {
    stream.zigzag((value as Number).toLong(), false)
}

private fun eiv(stream: OutputStream, value: Any) {
    stream.zigzag((value as Number).toLong(), true)
}

private fun ef4(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeFloat(value as Float)

private fun ef8(stream: OutputStream, value: Any) =
    DataOutputStream(stream).writeDouble(value as Double)

private fun es(stream: OutputStream, value: Any) {
    stream.writeEnd(value as String)
}

private fun di1(stream: InputStream): Any =
    DataInputStream(stream).readByte()

private fun di2(stream: InputStream): Any =
    DataInputStream(stream).readShort()

private fun di4(stream: InputStream): Any =
    DataInputStream(stream).readInt()

private fun di8(stream: InputStream): Any =
    DataInputStream(stream).readLong()

private fun duv(stream: InputStream): Any =
    stream.zigzag(false)

private fun div(stream: InputStream): Any =
    stream.zigzag(true)

private fun df4(stream: InputStream): Any =
    DataInputStream(stream).readFloat()

private fun df8(stream: InputStream): Any =
    DataInputStream(stream).readDouble()

private fun ds(stream: InputStream): Any =
    stream.readEnd()
