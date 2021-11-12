package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class SetMapEnvPropertyClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val property = input.readByteEnum<Property>()
    val value = input.readInt()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onSetMapEnvProperty(this)

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
