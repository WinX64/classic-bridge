package dev.winx64.classicbridge.classic.network.serverbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeByteEnum
import io.netty.buffer.ByteBuf

class SetBlockServerboundPlayPacket(
    private val x: Short,
    private val y: Short,
    private val z: Short,
    private val mode: Mode,
    private val blockType: Byte
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeShort(x.toInt())
        writeShort(y.toInt())
        writeShort(z.toInt())
        writeByteEnum(mode)
        writeByte(blockType.toInt())
    }

    enum class Mode { DESTROYED, CREATED }
}
