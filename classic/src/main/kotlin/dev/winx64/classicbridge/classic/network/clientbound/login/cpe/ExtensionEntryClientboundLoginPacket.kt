package dev.winx64.classicbridge.classic.network.clientbound.login.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtensionEntryClientboundLoginPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicLoginPacketCallback> {

    val extensionName = input.readString()
    val version = input.readInt()

    override fun notifyCallback(callback: ClassicLoginPacketCallback) = callback.onExtensionEntry(this)
}
