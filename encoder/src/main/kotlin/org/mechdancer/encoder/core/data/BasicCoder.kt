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
    I1(
          { stream, value -> DataOutputStream(stream).writeByte((value as Number).toInt()) },
          { stream -> DataInputStream(stream).readByte() }
      ),
    I2(
          { stream, value -> DataOutputStream(stream).writeShort((value as Number).toInt()) },
          { stream -> DataInputStream(stream).readShort() }
      ),
    I4(
          { stream, value -> DataOutputStream(stream).writeInt(value as Int) },
          { stream -> DataInputStream(stream).readInt() }
      ),
    I8(
          { stream, value -> DataOutputStream(stream).writeLong(value as Long) },
          { stream -> DataInputStream(stream).readLong() }
      ),
    Uv(
          { stream, value -> stream.zigzag((value as Number).toLong(), false) },
          { stream -> stream.zigzag(false) }
      ),
    Iv(
          { stream, value -> stream.zigzag((value as Number).toLong(), true) },
          { stream -> stream.zigzag(true) }
      ),
    F4(
          { stream, value -> DataOutputStream(stream).writeFloat(value as Float) },
          { stream -> DataInputStream(stream).readFloat() }
      ),
    F8(
          { stream, value -> DataOutputStream(stream).writeDouble(value as Double) },
          { stream -> DataInputStream(stream).readDouble() }
      ),
    S(
         { stream, value -> stream.writeEnd(value as String) },
         { stream -> stream.readEnd() }
     );

    companion object {
        private val types = enumValues<BasicCoder>().map(Enum<*>::name)

        operator fun contains(type: String) = type in types

        val Encoders = enumValues<BasicCoder>().associate {
            it.name to it.encoder
        }

        val Decoders = enumValues<BasicCoder>().associate {
            it.name to it.decoder
        }
    }
}
