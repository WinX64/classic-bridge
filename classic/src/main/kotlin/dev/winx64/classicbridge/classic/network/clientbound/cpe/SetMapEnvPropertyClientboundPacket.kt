package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class SetMapEnvPropertyClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val property = input.readByteEnum<Property>()
    val value = input.readInt()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onSetMapEnvProperty(this)

    enum class Property {
        SIDE_BLOCK_ID,
        EDGE_BLOCK_ID,
        EDGE_HEIGHT,
        CLOUD_HEIGHT,
        MAX_VIEW_DISTANCE,
        CLOUD_SPEED,
        WEATHER_SPEED,
        WEATHER_FADE,
        USE_EXPONENTIAL_FOG,
        MAP_SIDE_OFFSET
    }
}
