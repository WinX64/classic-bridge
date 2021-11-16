package dev.winx64.classicbridge.classic.network.clientbound

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

class UpdateUserTypeClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val userType = input.readByte()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onUpdateUserType(this)
}
