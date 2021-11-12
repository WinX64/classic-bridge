package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtAddPlayerNameClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val nameId = input.readShort()
    val playerName = input.readString()
    val listName = input.readString()
    val groupName = input.readString()
    val groupRank = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onExtAddPlayerName(this)
}
