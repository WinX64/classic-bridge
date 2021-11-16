package dev.winx64.classicbridge.classic.network.serverbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import io.netty.buffer.ByteBuf

class PositionAndOrientationServerboundPacket(
    private val playerId: Byte,
    private val x: Int,
    private val y: Int,
    private val z: Int,
    private val yaw: Byte,
    private val pitch: Byte
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeByte(playerId.toInt())

        if (settings.supports(EXT_ENTITY_POSITIONS)) {
            writeInt(x)
            writeInt(y)
            writeInt(z)
        } else {
            writeShort(x)
            writeShort(y)
            writeShort(z)
        }

        writeByte(yaw.toInt())
        writeByte(pitch.toInt())
    }
}
