package dev.winx64.classicbridge.classic.network.clientbound.login

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ServerIdentificationClientboundLoginPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicLoginPacketCallback> {

    val protocolVersion = input.readByte()
    val serverName = input.readString()
    val serverMOTD = input.readString()
    val userType = input.readByte()

    override fun notifyCallback(callback: ClassicLoginPacketCallback) = callback.onServerIdentification(this)
}
