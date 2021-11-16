package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class CustomBlockSupportLevelClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val supportLevel = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onCustomBlockSupportLevel(this)
}
