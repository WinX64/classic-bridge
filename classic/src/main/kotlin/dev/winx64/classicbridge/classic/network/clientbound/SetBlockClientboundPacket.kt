package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class SetBlockClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val x = input.readShort()
    val y = input.readShort()
    val z = input.readShort()
    val blockType = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetBlock(this)
}
