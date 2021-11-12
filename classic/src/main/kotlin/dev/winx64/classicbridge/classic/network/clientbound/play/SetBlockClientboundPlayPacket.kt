package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class SetBlockClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val x = input.readShort()
    val y = input.readShort()
    val z = input.readShort()
    val blockType = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetBlock(this)
}
