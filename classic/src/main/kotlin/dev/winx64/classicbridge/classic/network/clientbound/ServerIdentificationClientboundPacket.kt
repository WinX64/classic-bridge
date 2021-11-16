package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ServerIdentificationClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val protocolVersion = input.readByte()
    val serverName = input.readString()
    val serverMOTD = input.readString()
    val userType = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onServerIdentification(this)
}
