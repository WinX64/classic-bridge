package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readByteArray
import dev.winx64.classicbridge.classic.network.readIntArray
import io.netty.buffer.ByteBuf

class BulkBlockUpdateClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val count = input.readUnsignedByte()
    val indices = input.readIntArray(size = 256)
    val blocks = input.readByteArray(size = 256)

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onBulkBlockUpdate(this)
}
