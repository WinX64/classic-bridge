package dev.winx64.classicbridge.classic.network

import dev.winx64.classicbridge.classic.cpe.ExtensionType.EXT_ENTITY_POSITIONS
import dev.winx64.classicbridge.classic.network.callback.ClassicLoginPacketCallback
import dev.winx64.classicbridge.classic.network.callback.ClassicPacketCallback
import dev.winx64.classicbridge.classic.network.callback.ClassicPlayPacketCallback
import dev.winx64.classicbridge.classic.network.clientbound.login.*
import dev.winx64.classicbridge.classic.network.clientbound.login.cpe.ExtensionEntryClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.login.cpe.ExtensionInfoClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.play.*
import dev.winx64.classicbridge.classic.network.clientbound.play.cpe.*
import dev.winx64.classicbridge.classic.network.serverbound.login.PlayerIdentificationServerboundLoginPacket
import dev.winx64.classicbridge.classic.network.serverbound.login.cpe.ExtensionEntryServerboundLoginPacket
import dev.winx64.classicbridge.classic.network.serverbound.login.cpe.ExtensionInfoServerboundLoginPacket
import dev.winx64.classicbridge.classic.network.serverbound.play.MessageServerboundPlayPacket
import dev.winx64.classicbridge.classic.network.serverbound.play.PositionAndOrientationServerboundPlayPacket
import dev.winx64.classicbridge.classic.network.serverbound.play.SetBlockServerboundPlayPacket
import dev.winx64.classicbridge.classic.network.serverbound.play.cpe.TwoWayPingServerboundPlayPacket

enum class ClassicGameState(
    private val inboundPacketRegistry: InboundPacketRegistry<out ClassicPacketCallback>,
    private val outboundPacketRegistry: OutboundPacketRegistry,
) {
    LOGIN(
        incomingPackets<ClassicLoginPacketCallback> {
            //Standard protocol
            fixedSize(0x00, ::ServerIdentificationClientboundLoginPacket, 130)
            fixedSize(0x01, ::PingClientboundLoginPacket, 0)
            fixedSize(0x0E, ::DisconnectPlayerClientboundLoginPacket, 64)

            //Classic Protocol Extension
            fixedSize(0x10, ::ExtensionInfoClientboundLoginPacket, 66)
            fixedSize(0x11, ::ExtensionEntryClientboundLoginPacket, 68)
        },
        outgoingPackets {
            //Standard protocol
            fixedSize(0x00, PlayerIdentificationServerboundLoginPacket::class, 130)

            //Classic Protocol Extension
            fixedSize(0x10, ExtensionInfoServerboundLoginPacket::class, 66)
            fixedSize(0x11, ExtensionEntryServerboundLoginPacket::class, 68)
        }
    ),
    PLAY(
        incomingPackets<ClassicPlayPacketCallback> {
            //Standard Protocol
            fixedSize(0x00, ::ServerIdentificationClientboundPlayPacket, 130)
            fixedSize(0x01, ::PingClientboundPlayPacket, 0)
            fixedSize(0x02, ::LevelInitializeClientboundPlayPacket, 0)
            fixedSize(0x03, ::LevelDataChunkClientboundPlayPacket, 1027)
            fixedSize(0x04, ::LevelFinalizeClientboundPlayPacket, 6)
            fixedSize(0x06, ::SetBlockClientboundPlayPacket, 7)
            dynamicSize(0x07, ::SpawnPlayerClientboundPlayPacket, EXT_ENTITY_POSITIONS v 1, 10, 16)
            dynamicSize(0x08, ::TeleportClientboundPlayPacket, EXT_ENTITY_POSITIONS v 1, 15, 9)
            fixedSize(0x09, ::PositionAndOrientationClientboundPlayPacket, 6)
            fixedSize(0x0A, ::PositionClientboundPlayPacket, 4)
            fixedSize(0x0B, ::OrientationClientboundPlayPacket, 3)
            fixedSize(0x0C, ::DespawnPlayerClientboundPlayPacket, 1)
            fixedSize(0x0D, ::MessageClientboundPlayPacket, 65)
            fixedSize(0x0E, ::DisconnectPlayerClientboundPlayPacket, 64)
            fixedSize(0x0F, ::UpdateUserTypeClientboundPlayPacket, 1)

            //Classic Protocol Extension
            fixedSize(0x12, ::SetClickDistanceClientboundPlayPacket, 2)
            fixedSize(0x13, ::CustomBlockSupportLevelClientboundPlayPacket, 1)
            fixedSize(0x14, ::HoldThisClientboundPlayPacket, 2)
            fixedSize(0x16, ::ExtAddPlayerNameClientboundPlayPacket, 195)
            fixedSize(0x18, ::ExtRemovePlayerNameClientboundPlayPacket, 2)
            fixedSize(0x1C, ::SetBlockPermissionClientboundPlayPacket, 3)
            fixedSize(0x1F, ::EnvSetWeatherTypeClientboundPlayPacket, 1)
            dynamicSize(0x21, ::ExtAddEntityV2ClientboundPlayPacket, EXT_ENTITY_POSITIONS v 1, 143, 137)
            fixedSize(0x26, ::BulkBlockUpdateClientboundPlayPacket, 1281)
            fixedSize(0x28, ::SetMapEnvURLClientboundPlayPacket, 64)
            fixedSize(0x29, ::SetMapEnvPropertyClientboundPlayPacket, 5)
            fixedSize(0x2B, ::TwoWayPingClientboundPlayPacket, 3)
            fixedSize(0x2D, ::SetHotbarClientboundPlayPacket, 2)
            fixedSize(0x2E, ::SetSpawnpointClientboundPlayPacket, 8)
            fixedSize(0x2F, ::VelocityControlClientboundPlayPacket, 15)
        },
        outgoingPackets {
            //Standard Protocol
            fixedSize(0x05, SetBlockServerboundPlayPacket::class, 8)
            dynamicSize(0x08, PositionAndOrientationServerboundPlayPacket::class, EXT_ENTITY_POSITIONS v 1, 9, 15)
            fixedSize(0x0D, MessageServerboundPlayPacket::class, 65)

            //Classic Protocol Extension
            fixedSize(0x2B, TwoWayPingServerboundPlayPacket::class, 3)
        }
    )
}
