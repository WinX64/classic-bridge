package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class SetHotbarClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val blockId = input.readUnsignedByte()
    val hotbarIndex = input.readUnsignedByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetHotbar(this)
}
