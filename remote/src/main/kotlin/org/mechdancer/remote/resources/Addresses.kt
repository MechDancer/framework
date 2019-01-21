package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import java.net.Inet4Address
import java.net.InetSocketAddress
import java.util.concurrent.ConcurrentHashMap

/**
 * 地址资源
 *
 * 记录成员的地址和端口
 */
class Addresses : UniqueComponent<Addresses>() {
    private val core = ConcurrentHashMap<String, InetSocketAddress>()

    operator fun set(name: String, address: Inet4Address) =
        core.compute(name) { _, last ->
            InetSocketAddress(address, last?.port ?: 0)
        }

    operator fun set(name: String, port: Int) =
        core.compute(name) { _, last ->
            InetSocketAddress(
                last?.address ?: Inet4Address.getByAddress(ByteArray(0)),
                port
            )
        }

    operator fun set(name: String, socket: InetSocketAddress) =
        core.put(name, socket)

    operator fun get(name: String) =
        core[name]?.takeUnless { it.port == 0 }

    infix fun remove(name: String) =
        core.remove(name)
}
