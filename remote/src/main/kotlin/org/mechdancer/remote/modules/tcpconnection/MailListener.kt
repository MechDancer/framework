package org.mechdancer.remote.modules.tcpconnection

import org.mechdancer.dependency.Component

interface MailListener : Component {
    fun process(sender: String, payload: ByteArray)
}
