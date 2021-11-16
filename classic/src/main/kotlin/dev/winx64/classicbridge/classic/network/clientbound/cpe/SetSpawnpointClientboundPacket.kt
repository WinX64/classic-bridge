package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class SetSpawnpointClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val spawnX = input.readShort()
    val spawnY = input.readShort()
    val spawnZ = input.readShort()
    val spawnYaw = input.readByte()
    val spawnPitch = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetSpawnpoint(this)
}
