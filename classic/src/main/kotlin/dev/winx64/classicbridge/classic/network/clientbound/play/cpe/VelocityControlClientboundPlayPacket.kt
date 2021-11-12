package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class VelocityControlClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val velocityX = input.readInt()
    val velocityY = input.readInt()
    val velocityZ = input.readInt()
    val modeX = input.readByte()
    val modeY = input.readByte()
    val modeZ = input.readByte()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onVelocityControl(this)
}
