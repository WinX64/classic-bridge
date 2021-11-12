package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readByteArray
import io.netty.buffer.ByteBuf

class LevelDataChunkClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val chunkLength = input.readShort()
    val chunkData = input.readByteArray()
    val percentComplete = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onLevelDataChunk(this)
}
