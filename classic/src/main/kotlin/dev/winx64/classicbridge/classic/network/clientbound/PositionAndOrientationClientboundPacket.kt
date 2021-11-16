package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class PositionAndOrientationClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val playerId = input.readByte()
    val deltaX = input.readByte()
    val deltaY = input.readByte()
    val deltaZ = input.readByte()
    val yaw = input.readByte()
    val pitch = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onPositionAndOrientation(this)
}
