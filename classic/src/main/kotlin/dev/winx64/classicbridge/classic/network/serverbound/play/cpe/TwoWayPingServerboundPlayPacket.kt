package dev.winx64.classicbridge.classic.network.serverbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeByteEnum
import io.netty.buffer.ByteBuf

class TwoWayPingServerboundPlayPacket(
    private val direction: Direction,
    private val data: Short
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeByteEnum(direction)
        writeShort(data.toInt())
    }

    enum class Direction { CLIENT_TO_SERVER, SERVER_TO_CLIENT }
}
