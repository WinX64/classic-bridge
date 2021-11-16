package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class SetTextColorClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val red = input.readUnsignedByte()
    val green = input.readUnsignedByte()
    val blue = input.readUnsignedByte()
    val alpha = input.readUnsignedByte()
    val code = input.readUnsignedByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetTextColor(this)
}
