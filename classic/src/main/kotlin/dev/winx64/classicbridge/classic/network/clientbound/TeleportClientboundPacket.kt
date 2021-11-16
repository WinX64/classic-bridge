package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class TeleportClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val playerId = input.readByte()
    val x = input.readPosition(settings)
    val y = input.readPosition(settings)
    val z = input.readPosition(settings)
    val yaw = input.readByte()
    val pitch = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onTeleport(this)

    private fun ByteBuf.readPosition(settings: ExtensionSettings) = if (settings.supports(EXT_ENTITY_POSITIONS)) {
        readInt()
    } else {
        readShort().toInt()
    }
}
