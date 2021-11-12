package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import io.netty.buffer.ByteBuf

class SetBlockPermissionClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val blockType = input.readByte()
    val allowPlacement = input.readBoolean()
    val allowDeletion = input.readBoolean()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetBlockPermission(this)
}
