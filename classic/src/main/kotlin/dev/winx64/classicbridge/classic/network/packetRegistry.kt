package dev.winx64.classicbridge.classic.network

import dev.winx64.classicbridge.classic.cpe.ExtensionSettings
import dev.winx64.classicbridge.classic.cpe.ExtensionType
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import io.netty.buffer.ByteBuf
import kotlin.reflect.KClass

class InboundPacketRegistry<C : ClassicPacketCallback>(
    private val registeredPackets: Map<Int, Pair<PacketConstructor<C>, SizeCalculator>>
) {
    fun getPacketSizeCalculator(packetId: Int) = registeredPackets[packetId]?.second
        ?: throw IllegalArgumentException("No size calculator for packet id $packetId")

    fun getPacketConstructor(packetId: Int) = registeredPackets[packetId]?.first
        ?: throw IllegalArgumentException("No constructor for packet id $packetId")

    class DSL<C : ClassicPacketCallback>(
        private val map: MutableMap<Int, Pair<PacketConstructor<C>, SizeCalculator>>
    ) {
        fun fixedSize(
            id: Int,
            packetConstructor: PacketConstructor<C>,
            size: Int
        ) {
            map[id] = Pair(packetConstructor) { size }
        }

        fun dynamicSize(
            id: Int,
            packetConstructor: PacketConstructor<C>,
            requiredExtension: Pair<ExtensionType, Int>,
            extendedSize: Int,
            normalSize: Int
        ) {
            map[id] = Pair(packetConstructor) {
                if (it.supports(requiredExtension)) extendedSize else normalSize
            }
        }
    }
}

typealias PacketConstructor<C> = (ByteBuf, ExtensionSettings) -> ClassicInboundPacket<C>

typealias SizeCalculator = (ExtensionSettings) -> Int

class OutboundPacketRegistry(
    private val registeredPackets: Map<KClass<out ClassicOutboundPacket>, Pair<Int, SizeCalculator>>
) {
    fun getPacketId(packetClass: KClass<out ClassicOutboundPacket>) = registeredPackets[packetClass]?.first
        ?: throw IllegalArgumentException("No packet id for class ${packetClass.simpleName}")

    fun getPacketSizeCalculator(packetClass: KClass<out ClassicOutboundPacket>) = registeredPackets[packetClass]?.second
        ?: throw java.lang.IllegalArgumentException("No packet size calculator for class ${packetClass.simpleName}")

    class DSL(private val map: MutableMap<KClass<out ClassicOutboundPacket>, Pair<Int, SizeCalculator>>) {

        fun fixedSize(
            id: Int,
            packetClass: KClass<out ClassicOutboundPacket>,
            size: Int
        ) {
            map[packetClass] = Pair(id) { size }
        }

        fun dynamicSize(
            id: Int,
            packetClass: KClass<out ClassicOutboundPacket>,
            requiredExtension: Pair<ExtensionType, Int>,
            extendedSize: Int,
            normalSize: Int
        ) {
            map[packetClass] = Pair(id) {
                if (it.supports(requiredExtension)) extendedSize else normalSize
            }
        }
    }
}

fun <C : ClassicPacketCallback> incomingPackets(
    block: InboundPacketRegistry.DSL<C>.() -> Unit
): InboundPacketRegistry<C> {
    val map = mutableMapOf<Int, Pair<PacketConstructor<C>, SizeCalculator>>()

    InboundPacketRegistry.DSL(map).also(block).also {
        return InboundPacketRegistry(map)
    }
}

fun outgoingPackets(block: OutboundPacketRegistry.DSL.() -> Unit): OutboundPacketRegistry {
    val map = mutableMapOf<KClass<out ClassicOutboundPacket>, Pair<Int, SizeCalculator>>()

    OutboundPacketRegistry.DSL(map).also(block).also {
        return OutboundPacketRegistry(map)
    }
}
