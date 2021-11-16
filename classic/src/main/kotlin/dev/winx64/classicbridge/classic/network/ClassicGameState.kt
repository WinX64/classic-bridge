package dev.winx64.classicbridge.classic.network

import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.clientbound.*
import dev.winx64.classicbridge.classic.network.clientbound.cpe.*
import dev.winx64.classicbridge.classic.network.serverbound.MessageServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.PlayerIdentificationServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.PositionAndOrientationServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.SetBlockServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.cpe.ExtensionEntryServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.cpe.ExtensionInfoServerboundPacket
import dev.winx64.classicbridge.classic.network.serverbound.cpe.TwoWayPingServerboundPacket

object ClassicGameState {

    private val inboundPacketRegistry = incomingPackets {
        //Standard Protocol
        fixedSize(0x00, ::ServerIdentificationClientboundPacket, 130)
        fixedSize(0x01, ::PingClientboundPacket, 0)
        fixedSize(0x02, ::LevelInitializeClientboundPacket, 0)
        fixedSize(0x03, ::LevelDataChunkClientboundPacket, 1027)
        fixedSize(0x04, ::LevelFinalizeClientboundPacket, 6)
        fixedSize(0x06, ::SetBlockClientboundPacket, 7)
        dynamicSize(0x07, ::SpawnPlayerClientboundPacket, EXT_ENTITY_POSITIONS v 1, 79, 73)
        dynamicSize(0x08, ::TeleportClientboundPacket, EXT_ENTITY_POSITIONS v 1, 15, 9)
        fixedSize(0x09, ::PositionAndOrientationClientboundPacket, 6)
        fixedSize(0x0A, ::PositionClientboundPacket, 4)
        fixedSize(0x0B, ::OrientationClientboundPacket, 3)
        fixedSize(0x0C, ::DespawnPlayerClientboundPacket, 1)
        fixedSize(0x0D, ::MessageClientboundPacket, 65)
        fixedSize(0x0E, ::DisconnectPlayerClientboundPacket, 64)
        fixedSize(0x0F, ::UpdateUserTypeClientboundPacket, 1)

        //Classic Protocol Extension
        fixedSize(0x10, ::ExtensionInfoClientboundPacket, 66)
        fixedSize(0x11, ::ExtensionEntryClientboundPacket, 68)
        fixedSize(0x12, ::SetClickDistanceClientboundPacket, 2)
        fixedSize(0x13, ::CustomBlockSupportLevelClientboundPacket, 1)
        fixedSize(0x14, ::HoldThisClientboundPacket, 2)
        fixedSize(0x16, ::ExtAddPlayerNameClientboundPacket, 195)
        fixedSize(0x18, ::ExtRemovePlayerNameClientboundPacket, 2)
        fixedSize(0x1C, ::SetBlockPermissionClientboundPacket, 3)
        fixedSize(0x1F, ::EnvSetWeatherTypeClientboundPacket, 1)
        dynamicSize(0x21, ::ExtAddEntityV2ClientboundPacket, EXT_ENTITY_POSITIONS v 1, 143, 137)
        fixedSize(0x26, ::BulkBlockUpdateClientboundPacket, 1281)
        fixedSize(0x28, ::SetMapEnvURLClientboundPacket, 64)
        fixedSize(0x29, ::SetMapEnvPropertyClientboundPacket, 5)
        fixedSize(0x2B, ::TwoWayPingClientboundPacket, 3)
        fixedSize(0x2D, ::SetHotbarClientboundPacket, 2)
        fixedSize(0x2E, ::SetSpawnpointClientboundPacket, 8)
        fixedSize(0x2F, ::VelocityControlClientboundPacket, 15)
    }

    private val outboundPacketRegistry = outgoingPackets {
        //Standard Protocol
        fixedSize(0x00, PlayerIdentificationServerboundPacket::class, 130)
        fixedSize(0x05, SetBlockServerboundPacket::class, 8)
        dynamicSize(0x08, PositionAndOrientationServerboundPacket::class, EXT_ENTITY_POSITIONS v 1, 9, 15)
        fixedSize(0x0D, MessageServerboundPacket::class, 65)

        //Classic Protocol Extension
        fixedSize(0x10, ExtensionInfoServerboundPacket::class, 66)
        fixedSize(0x11, ExtensionEntryServerboundPacket::class, 68)
        fixedSize(0x2B, TwoWayPingServerboundPacket::class, 3)
    }

    fun getInboundPacketRegistration(packetId: Int) = inboundPacketRegistry.getRegistration(packetId)

    fun getOutboundPacketRegistration(packetClass: PacketClass) = outboundPacketRegistry.getRegistration(packetClass)
}
