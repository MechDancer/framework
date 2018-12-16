package org.mechdancer.remote.protocol

import java.io.InputStream

class SimpleInputStream(
    val core: ByteArray,
    private var ptr: Int = 0,
    private val end: Int = core.size
) : InputStream() {
    override fun available() = end - ptr

    override fun read() =
        if (ptr < end)
            core[ptr++].let { if (it >= 0) it.toInt() else it + 256 }
        else -1

    fun look() = core[ptr]

    infix fun skip(length: Int) = also { ptr += length }

    fun lookRest() =
        ByteArray(end - ptr)
            .also { core.copyInto(it, 0, ptr, end) }

    fun readInto(stream: SimpleOutputStream, length: Int) {
        stream.writeLength(core, ptr, length)
        ptr += length
    }

    override fun close() {
        ptr = end
    }
}
