package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtensionInfoClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val appName = input.readString()
    val extensionCount = input.readShort()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onExtensionInfo(this)
}
