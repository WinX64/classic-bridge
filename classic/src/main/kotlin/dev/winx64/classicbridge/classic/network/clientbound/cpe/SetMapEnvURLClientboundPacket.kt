package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class SetMapEnvURLClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val texturePackURL = input.readString()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetMapEnvURL(this)
}
