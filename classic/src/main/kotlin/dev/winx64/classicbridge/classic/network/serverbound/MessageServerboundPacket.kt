package dev.winx64.classicbridge.classic.network.serverbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeString
import io.netty.buffer.ByteBuf

class MessageServerboundPacket(
    private val unused: Byte,
    private val message: String
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeByte(unused.toInt())
        writeString(message)
    }
}
