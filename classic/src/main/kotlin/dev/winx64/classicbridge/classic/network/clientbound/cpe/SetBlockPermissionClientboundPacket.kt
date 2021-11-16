package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class SetBlockPermissionClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val blockType = input.readByte()
    val allowPlacement = input.readBoolean()
    val allowDeletion = input.readBoolean()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetBlockPermission(this)
}
