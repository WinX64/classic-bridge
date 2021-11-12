package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class TwoWayPingClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val direction = input.readByteEnum<Direction>()
    val data = input.readShort()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onTwoWayPing(this)

    enum class Direction { CLIENT_TO_SERVER, SERVER_TO_CLIENT }
}
