package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class TwoWayPingClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val direction = input.readByteEnum<Direction>()
    val data = input.readShort()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onTwoWayPing(this)

    enum class Direction { CLIENT_TO_SERVER, SERVER_TO_CLIENT }
}
