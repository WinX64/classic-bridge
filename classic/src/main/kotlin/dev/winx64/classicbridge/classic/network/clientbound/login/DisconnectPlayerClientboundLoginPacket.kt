package dev.winx64.classicbridge.classic.network.clientbound.login

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class DisconnectPlayerClientboundLoginPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicLoginPacketCallback> {

    val reason = input.readString()

    override fun notifyCallback(callback: ClassicLoginPacketCallback) = callback.onDisconnectPlayer(this)
}
