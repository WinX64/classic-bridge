package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class LevelInitializeClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onLevelInitialize(this)
}
