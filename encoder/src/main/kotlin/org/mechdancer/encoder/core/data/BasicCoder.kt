package org.mechdancer.encoder.core.data

import org.mechdancer.encoder.util.readEnd
import org.mechdancer.encoder.util.writeEnd
import org.mechdancer.encoder.util.zigzag
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStream
import java.io.OutputStream

internal enum class BasicCoder(
    val encoder: (OutputStream, Any) -> Unit,
    val decoder: (InputStream) -> Any
) {
    // Byte
    I1({ stream, value -> DataOutputStream(stream).writeByte((value as Number).toInt()) },
       { stream -> DataInputStream(stream).readByte() }),
    // Short
    I2({ stream, value -> DataOutputStream(stream).writeShort((value as Number).toInt()) },
       { stream -> DataInputStream(stream).readShort() }),
    // Int
    I4({ stream, value -> DataOutputStream(stream).writeInt(value as Int) },
       { stream -> DataInputStream(stream).readInt() }),
    // Long
    I8({ stream, value -> DataOutputStream(stream).writeLong(value as Long) },
       { stream -> DataInputStream(stream).readLong() }),
    // Unsigned VarInt
    Uv({ stream, value -> stream.zigzag((value as Number).toLong(), false) },
       { stream -> stream.zigzag(false) }),
    // VarInt
    Iv({ stream, value -> stream.zigzag((value as Number).toLong(), true) },
       { stream -> stream.zigzag(true) }),
    // Float
    F4({ stream, value -> DataOutputStream(stream).writeFloat(value as Float) },
       { stream -> DataInputStream(stream).readFloat() }),
    // Double
    F8({ stream, value -> DataOutputStream(stream).writeDouble(value as Double) },
       { stream -> DataInputStream(stream).readDouble() }),
    // String
    S({ stream, value -> stream.writeEnd(value as String) },
      { stream -> stream.readEnd() }),
    // Reference
    R({ stream, value -> stream.zigzag((value as Int).toLong(), false) },
      { stream -> stream.zigzag(false).toInt() });

    companion object {
        private val types =
            enumValues<BasicCoder>().map(Enum<*>::name)

        private val encoders =
            enumValues<BasicCoder>()
                .associate { it.name to it.encoder }

        private val decoders =
            enumValues<BasicCoder>()
                .associate { it.name to it.decoder }

        operator fun contains(type: String) = type != R.name && type in types

        fun encoder(type: String) = encoders[type] ?: R.encoder
        fun decoder(type: String) = decoders[type] ?: R.decoder
    }
}
