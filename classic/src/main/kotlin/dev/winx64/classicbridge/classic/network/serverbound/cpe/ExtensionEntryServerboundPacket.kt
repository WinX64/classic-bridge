package dev.winx64.classicbridge.classic.network.serverbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeString
import io.netty.buffer.ByteBuf

class ExtensionEntryServerboundPacket(
    private val extensionName: String,
    private val version: Int
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeString(extensionName)
        writeInt(version)
    }
}
