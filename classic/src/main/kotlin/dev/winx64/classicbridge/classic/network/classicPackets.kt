package dev.winx64.classicbridge.classic.network

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf

interface ClassicInboundPacket<C : ClassicPacketCallback> {

    fun notifyCallback(callback: C)
}

interface ClassicOutboundPacket {

    fun write(output: ByteBuf, settings: ExtensionSettings)
}
