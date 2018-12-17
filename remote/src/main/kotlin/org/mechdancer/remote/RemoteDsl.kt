package org.mechdancer.remote

import org.mechdancer.dependency.Component
import java.net.InetAddress
import java.net.InetSocketAddress

/** 远程终端构建器 */
class RemoteDsl private constructor() {
    private var newMemberDetected: (String) -> Unit = {}
    private var dependencies = mutableListOf<Component>()

    fun newMemberDetected(block: (String) -> Unit) {
        newMemberDetected = block
    }

    fun inAddition(block: () -> Component) {
        dependencies.add(block())
    }

    companion object {
        private val ADDRESS = InetSocketAddress(InetAddress.getByName("233.33.33.33"), 23333)

        fun remoteHub(
            name: String? = null,
            address: InetSocketAddress = ADDRESS,
            sliceSize: Int = 0x4000,
            block: RemoteDsl.() -> Unit = {}
        ) = RemoteDsl()
            .apply(block)
            .let {
                RemoteHub(
                    name,
                    address,
                    sliceSize,
                    it.newMemberDetected,
                    it.dependencies
                )
            }
    }
}
