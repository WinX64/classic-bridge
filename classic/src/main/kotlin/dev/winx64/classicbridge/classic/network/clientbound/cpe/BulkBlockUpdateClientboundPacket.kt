package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readByteArray
import dev.winx64.classicbridge.classic.network.readIntArray
import io.netty.buffer.ByteBuf

class BulkBlockUpdateClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val count = input.readUnsignedByte()
    val indices = input.readIntArray(size = 256)
    val blocks = input.readByteArray(size = 256)

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onBulkBlockUpdate(this)
}
