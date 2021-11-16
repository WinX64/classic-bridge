package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class ExtAddPlayerNameClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val nameId = input.readShort()
    val playerName = input.readString()
    val listName = input.readString()
    val groupName = input.readString()
    val groupRank = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onExtAddPlayerName(this)
}
