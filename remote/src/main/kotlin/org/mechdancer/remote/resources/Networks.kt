package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.dependency.buildView
import java.net.Inet4Address
import java.net.InterfaceAddress
import java.net.NetworkInterface

/**
 * 网络端口扫描器
 */
class Networks : UniqueComponent<Networks>() {
    private val core = mutableMapOf<NetworkInterface, InterfaceAddress>()
    val view = buildView(core)

    init {
        scan()
    }

    /**
     * 扫描全部 IP 地址
     * 耗时为亚秒级，谨慎使用
     */
    fun scan() {
        val new = NetworkInterface
            .getNetworkInterfaces()
            .asSequence()
            .filter(NetworkInterface::isUp)
            .filter(NetworkInterface::supportsMulticast)
            .notLoopback()
            .notDocker()
            .notVmware()
            .mapNotNull { network ->
                network
                    .interfaceAddresses
                    .filter { it.address is Inet4Address }
                    .singleOrNull(::isMono)
                    ?.let { network to it }
            }

        synchronized(core) {
            core.clear()
            core.putAll(new)
        }
    }

    fun get(parameter: NetworkInterface) = core[parameter]

    private companion object {
        fun Sequence<NetworkInterface>.notLoopback() =
            filterNot { network -> network.isLoopback }

        fun Sequence<NetworkInterface>.notDocker() =
            filterNot {
                fun check(it: String) = "docker" in it.toLowerCase()
                check(it.name) || check(it.displayName)
            }

        fun Sequence<NetworkInterface>.notVmware() =
            filterNot {
                fun check(it: String) = "vmware" in it.toLowerCase()
                check(it.name) || check(it.displayName)
            }

        fun isMono(it: InterfaceAddress) =
            it.address.address
                .first()
                .toInt()
                .and(0xff)
                .let { it in 1..223 && it != 127 }
    }
}
