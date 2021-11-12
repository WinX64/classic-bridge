package dev.winx64.classicbridge.classic.network.clientbound.login

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class PingClientboundLoginPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicLoginPacketCallback> {

    override fun notifyCallback(callback: ClassicLoginPacketCallback) = callback.onPing(this)
}
