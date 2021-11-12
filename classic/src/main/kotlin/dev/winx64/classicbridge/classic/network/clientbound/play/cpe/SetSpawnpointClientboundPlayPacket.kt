package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class SetSpawnpointClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val spawnX = input.readShort()
    val spawnY = input.readShort()
    val spawnZ = input.readShort()
    val spawnYaw = input.readByte()
    val spawnPitch = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetSpawnpoint(this)
}
