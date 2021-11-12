package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class TeleportClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val playerId = input.readByte()
    val x = input.readPosition(settings)
    val y = input.readPosition(settings)
    val z = input.readPosition(settings)
    val yaw = input.readByte()
    val pitch = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onTeleport(this)

    private fun ByteBuf.readPosition(settings: ExtensionSettings) = if (settings.supports(EXT_ENTITY_POSITIONS)) {
        readInt()
    } else {
        readShort().toInt()
    }
}
