package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class PingClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onPing(this)
}
