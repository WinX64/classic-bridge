package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtAddEntityV2ClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val entityId = input.readByte()
    val inGameName = input.readString()
    val skinName = input.readString()
    val spawnX = input.readPosition(settings)
    val spawnY = input.readPosition(settings)
    val spawnZ = input.readPosition(settings)
    val spawnYaw = input.readByte()
    val spawnPitch = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onExtAddEntityV2(this)

    private fun ByteBuf.readPosition(settings: ExtensionSettings) = if (settings.supports(EXT_ENTITY_POSITIONS)) {
        readInt()
    } else {
        readShort().toInt()
    }
}
