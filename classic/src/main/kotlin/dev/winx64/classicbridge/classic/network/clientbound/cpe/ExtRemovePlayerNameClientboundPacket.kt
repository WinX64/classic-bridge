package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class ExtRemovePlayerNameClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val nameId = input.readShort()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onExtRemovePlayerName(this)
}
