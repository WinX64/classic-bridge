package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ServerIdentificationClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val protocolVersion = input.readByte()
    val serverName = input.readString()
    val serverMOTD = input.readString()
    val userType = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onServerIdentification(this)
}
