package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class SetTextColorClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val red = input.readUnsignedByte()
    val green = input.readUnsignedByte()
    val blue = input.readUnsignedByte()
    val alpha = input.readUnsignedByte()
    val code = input.readUnsignedByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetTextColor(this)
}
