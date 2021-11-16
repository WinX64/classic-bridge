package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtensionEntryClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val extensionName = input.readString()
    val version = input.readInt()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onExtensionEntry(this)
}
