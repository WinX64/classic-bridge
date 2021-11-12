package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readString
import io.netty.buffer.ByteBuf

class DisconnectPlayerClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val reason = input.readString()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onDisconnectPlayer(this)
}
