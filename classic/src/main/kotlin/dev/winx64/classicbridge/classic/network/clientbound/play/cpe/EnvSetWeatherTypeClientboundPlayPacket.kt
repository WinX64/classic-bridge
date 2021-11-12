package dev.winx64.classicbridge.classic.network.clientbound.play.cpe

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.network.ClassicInboundPacket
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.readByteEnum
import io.netty.buffer.ByteBuf

class EnvSetWeatherTypeClientboundPlayPacket(
    input: ByteBuf,
    settings: ExtensionSettings
) : ClassicInboundPacket<ClassicPlayPacketCallback> {

    val weatherType = input.readByteEnum<WeatherType>()

    override fun notifyCallback(callback: ClassicPlayPacketCallback) = callback.onEnvSetWeatherType(this)

    enum class WeatherType { SUNNY, RAINING, SNOWING }
}
