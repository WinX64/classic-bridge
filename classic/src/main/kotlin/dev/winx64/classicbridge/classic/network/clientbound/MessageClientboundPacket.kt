package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class MessageClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val playerId = input.readByte()
    val message = input.readString()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onMessage(this)
}
