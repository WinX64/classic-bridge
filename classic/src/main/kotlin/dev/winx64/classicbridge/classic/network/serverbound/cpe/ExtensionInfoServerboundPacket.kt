package dev.winx64.classicbridge.classic.network.serverbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeString
import io.netty.buffer.ByteBuf

data class ExtensionInfoServerboundPacket(
    private val appName: String,
    private val extensionCount: Int
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeString(appName)
        writeShort(extensionCount)
    }
}
