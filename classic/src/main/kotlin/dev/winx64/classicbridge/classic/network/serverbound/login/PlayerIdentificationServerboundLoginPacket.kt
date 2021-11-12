package dev.winx64.classicbridge.classic.network.serverbound.login

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicOutboundPacket
import dev.winx64.classicbridge.classic.network.writeString
import io.netty.buffer.ByteBuf

class PlayerIdentificationServerboundLoginPacket(
    private val protocolVersion: Int,
    private val username: String,
    private val verificationKey: String,
    private val magicValue: Int
) : ClassicOutboundPacket {

    override fun write(output: ByteBuf, settings: ExtensionSettings): Unit = with(output) {
        writeByte(protocolVersion)
        writeString(username)
        writeString(verificationKey)
        writeByte(magicValue)
    }
}
