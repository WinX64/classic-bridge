package dev.winx64.classicbridge.classic.network.callback

import dev.winx64.classicbridge.classic.network.clientbound.*
import dev.winx64.classicbridge.classic.network.clientbound.cpe.*

interface ClassicPacketCallback {

    fun onServerIdentification(packet: ServerIdentificationClientboundPacket)

    fun onPing(packet: PingClientboundPacket)

    fun onLevelInitialize(packet: LevelInitializeClientboundPacket)

    fun onLevelDataChunk(packet: LevelDataChunkClientboundPacket)

    fun onLevelFinalize(packet: LevelFinalizeClientboundPacket)

    fun onSetBlock(packet: SetBlockClientboundPacket)

    fun onSpawnPlayer(packet: SpawnPlayerClientboundPacket)

    fun onTeleport(packet: TeleportClientboundPacket)

    fun onPositionAndOrientation(packet: PositionAndOrientationClientboundPacket)

    fun onPosition(packet: PositionClientboundPacket)

    fun onOrientation(packet: OrientationClientboundPacket)

    fun onDespawnPlayer(packet: DespawnPlayerClientboundPacket)

    fun onMessage(packet: MessageClientboundPacket)

    fun onDisconnectPlayer(packet: DisconnectPlayerClientboundPacket)

    fun onUpdateUserType(packet: UpdateUserTypeClientboundPacket)

    fun onExtensionInfo(packet: ExtensionInfoClientboundPacket)

    fun onExtensionEntry(packet: ExtensionEntryClientboundPacket)

    fun onClickDistance(packet: SetClickDistanceClientboundPacket)

    fun onCustomBlockSupportLevel(packet: CustomBlockSupportLevelClientboundPacket)

    fun onHoldThis(packet: HoldThisClientboundPacket)

    fun onExtAddPlayerName(packet: ExtAddPlayerNameClientboundPacket)

    fun onExtAddEntityV2(packet: ExtAddEntityV2ClientboundPacket)

    fun onExtRemovePlayerName(packet: ExtRemovePlayerNameClientboundPacket)

    fun onSetBlockPermission(packet: SetBlockPermissionClientboundPacket)

    fun onEnvSetWeatherType(packet: EnvSetWeatherTypeClientboundPacket)

    fun onBulkBlockUpdate(packet: BulkBlockUpdateClientboundPacket)

    fun onSetTextColor(packet: SetTextColorClientboundPacket)

    fun onSetMapEnvURL(packet: SetMapEnvURLClientboundPacket)

    fun onSetMapEnvProperty(packet: SetMapEnvPropertyClientboundPacket)

    fun onTwoWayPing(packet: TwoWayPingClientboundPacket)

    fun onSetHotbar(packet: SetHotbarClientboundPacket)

    fun onSetSpawnpoint(packet: SetSpawnpointClientboundPacket)

    fun onVelocityControl(packet: VelocityControlClientboundPacket)
}
