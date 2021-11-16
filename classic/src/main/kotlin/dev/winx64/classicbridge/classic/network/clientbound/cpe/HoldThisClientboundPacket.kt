package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class HoldThisClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val blockToHold = input.readByte()
    val preventChange = input.readBoolean()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onHoldThis(this)
}
