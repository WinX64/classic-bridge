package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class DespawnPlayerClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val playerId = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onDespawnPlayer(this)
}
