package dev.winx64.classicbridge.classic.network.clientbound.play

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class PositionAndOrientationClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val playerId = input.readByte()
    val deltaX = input.readByte()
    val deltaY = input.readByte()
    val deltaZ = input.readByte()
    val yaw = input.readByte()
    val pitch = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onPositionAndOrientation(this)
}
