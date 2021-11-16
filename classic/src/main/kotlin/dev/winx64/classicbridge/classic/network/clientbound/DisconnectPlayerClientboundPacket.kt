package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class DisconnectPlayerClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val reason = input.readString()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onDisconnectPlayer(this)
}
