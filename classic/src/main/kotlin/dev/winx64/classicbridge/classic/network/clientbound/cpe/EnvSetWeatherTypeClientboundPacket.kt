package dev.winx64.classicbridge.classic.network.clientbound.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class EnvSetWeatherTypeClientboundPacket(input: ByteBuf, settings: ExtensionSettings) : ClassicInboundPacket {

    val weatherType = input.readByteEnum<WeatherType>()

    override fun notifyCallback(callback: ClassicPacketCallback) = callback.onEnvSetWeatherType(this)

    enum class WeatherType { SUNNY, RAINING, SNOWING }
}
