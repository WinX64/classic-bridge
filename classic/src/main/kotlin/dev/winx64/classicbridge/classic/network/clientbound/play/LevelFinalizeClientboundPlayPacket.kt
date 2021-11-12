package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class LevelFinalizeClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val sizeX = input.readShort()
    val sizeY = input.readShort()
    val sizeZ = input.readShort()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onLevelFinalize(this)
}
