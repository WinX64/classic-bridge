package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class VelocityControlClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val velocityX = input.readInt()
    val velocityY = input.readInt()
    val velocityZ = input.readInt()
    val modeX = input.readByte()
    val modeY = input.readByte()
    val modeZ = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onVelocityControl(this)
}
