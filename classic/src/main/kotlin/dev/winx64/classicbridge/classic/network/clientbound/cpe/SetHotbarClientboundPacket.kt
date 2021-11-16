package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class SetHotbarClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val blockId = input.readUnsignedByte()
    val hotbarIndex = input.readUnsignedByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetHotbar(this)
}
