package dev.winx64.classicbridge.classic.network

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType
import io.netty.buffer.ByteBuf
import kotlin.reflect.KClass

class InboundPacketRegistry(
    private val registeredPackets: Map<Int, InboundPacketRegistration>
) {
    fun getRegistration(packetId: Int) = registeredPackets[packetId]
        ?: throw IllegalArgumentException("No registration for packet id ${packetId.hexString()} ($packetId)")

    class DSL(
        private val map: MutableMap<Int, InboundPacketRegistration>
    ) {
        fun fixedSize(
            id: Int,
            packetConstructor: PacketConstructor,
            size: Int
        ) {
            map[id] = InboundPacketRegistration(packetConstructor) { size }
        }

        fun dynamicSize(
            id: Int,
            packetConstructor: PacketConstructor,
            requiredExtension: Pair<ExtensionType, Int>,
            extendedSize: Int,
            normalSize: Int
        ) {
            map[id] = InboundPacketRegistration(packetConstructor) {
                if (it.supports(requiredExtension)) extendedSize else normalSize
            }
        }
    }
}

class OutboundPacketRegistry(
    private val registeredPackets: Map<PacketClass, OutboundPacketRegistration>
) {
    fun getRegistration(packetClass: PacketClass) = registeredPackets[packetClass]
        ?: throw IllegalArgumentException("No registration for packet class ${packetClass.simpleName}")

    class DSL(private val map: MutableMap<PacketClass, OutboundPacketRegistration>) {

        fun fixedSize(
            id: Int,
            packetClass: KClass<out ClassicOutboundPacket>,
            size: Int
        ) {
            map[packetClass] = OutboundPacketRegistration(id) { size }
        }

        fun dynamicSize(
            id: Int,
            packetClass: KClass<out ClassicOutboundPacket>,
            requiredExtension: Pair<ExtensionType, Int>,
            extendedSize: Int,
            normalSize: Int
        ) {
            map[packetClass] = OutboundPacketRegistration(id) {
                if (it.supports(requiredExtension)) extendedSize else normalSize
            }
        }
    }
}

typealias PacketConstructor = (ByteBuf, ExtensionSettings) -> ClassicInboundPacket

typealias SizeCalculator = (ExtensionSettings) -> Int

typealias PacketClass = KClass<out ClassicOutboundPacket>

data class InboundPacketRegistration(
    val packetConstructor: PacketConstructor,
    val sizeCalculator: SizeCalculator
)

data class OutboundPacketRegistration(
    val packetId: Int,
    val sizeCalculator: SizeCalculator
)

fun incomingPackets(block: InboundPacketRegistry.DSL.() -> Unit): InboundPacketRegistry {
    val map = mutableMapOf<Int, InboundPacketRegistration>()

    InboundPacketRegistry.DSL(map).also(block).also {
        return InboundPacketRegistry(map)
    }
}

fun outgoingPackets(block: OutboundPacketRegistry.DSL.() -> Unit): OutboundPacketRegistry {
    val map = mutableMapOf<PacketClass, OutboundPacketRegistration>()

    OutboundPacketRegistry.DSL(map).also(block).also {
        return OutboundPacketRegistry(map)
    }
}
