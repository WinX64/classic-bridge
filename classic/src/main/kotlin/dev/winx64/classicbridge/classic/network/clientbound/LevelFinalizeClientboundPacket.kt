package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class LevelFinalizeClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val sizeX = input.readShort()
    val sizeY = input.readShort()
    val sizeZ = input.readShort()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onLevelFinalize(this)
}
