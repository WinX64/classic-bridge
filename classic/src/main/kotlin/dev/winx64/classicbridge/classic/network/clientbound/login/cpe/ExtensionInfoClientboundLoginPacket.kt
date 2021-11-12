package dev.winx64.classicbridge.classic.network.clientbound.login.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtensionInfoClientboundLoginPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicLoginPacketCallback> {

    val appName = input.readString()
    val extensionCount = input.readShort()

    override fun notifyCallback(callback: ClassicLoginPacketCallback) = callback.onExtensionInfo(this)
}
