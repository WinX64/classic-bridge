package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class OrientationClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val playerId = input.readByte()
    val yaw = input.readByte()
    val pitch = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onOrientation(this)
}
