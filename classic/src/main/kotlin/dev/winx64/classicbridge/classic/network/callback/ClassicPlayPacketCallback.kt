package dev.winx64.classicbridge.classic.network.callback

import dev.winx64.classicbridge.classic.network.clientbound.play.*
import dev.winx64.classicbridge.classic.network.clientbound.play.cpe.*

interface ClassicPlayPacketCallback : ClassicPacketCallback {

    fun onServerIdentification(packet: ServerIdentificationClientboundPlayPacket)

    fun onPing(packet: PingClientboundPlayPacket)

    fun onLevelInitialize(packet: LevelInitializeClientboundPlayPacket)

    fun onLevelDataChunk(packet: LevelDataChunkClientboundPlayPacket)

    fun onLevelFinalize(packet: LevelFinalizeClientboundPlayPacket)

    fun onSetBlock(packet: SetBlockClientboundPlayPacket)

    fun onSpawnPlayer(packet: SpawnPlayerClientboundPlayPacket)

    fun onTeleport(packet: TeleportClientboundPlayPacket)

    fun onPositionAndOrientation(packet: PositionAndOrientationClientboundPlayPacket)

    fun onPosition(packet: PositionClientboundPlayPacket)

    fun onOrientation(packet: OrientationClientboundPlayPacket)

    fun onDespawnPlayer(packet: DespawnPlayerClientboundPlayPacket)

    fun onMessage(packet: MessageClientboundPlayPacket)

    fun onDisconnectPlayer(packet: DisconnectPlayerClientboundPlayPacket)

    fun onUpdateUserType(packet: UpdateUserTypeClientboundPlayPacket)

    fun onClickDistance(packet: SetClickDistanceClientboundPlayPacket)

    fun onCustomBlockSupportLevel(packet: CustomBlockSupportLevelClientboundPlayPacket)

    fun onHoldThis(packet: HoldThisClientboundPlayPacket)

    fun onExtAddPlayerName(packet: ExtAddPlayerNameClientboundPlayPacket)

    fun onExtAddEntityV2(packet: ExtAddEntityV2ClientboundPlayPacket)

    fun onExtRemovePlayerName(packet: ExtRemovePlayerNameClientboundPlayPacket)

    fun onSetBlockPermission(packet: SetBlockPermissionClientboundPlayPacket)

    fun onEnvSetWeatherType(packet: EnvSetWeatherTypeClientboundPlayPacket)

    fun onBulkBlockUpdate(packet: BulkBlockUpdateClientboundPlayPacket)

    fun onSetTextColor(packet: SetTextColorClientboundPlayPacket)

    fun onSetMapEnvURL(packet: SetMapEnvURLClientboundPlayPacket)

    fun onSetMapEnvProperty(packet: SetMapEnvPropertyClientboundPlayPacket)

    fun onTwoWayPing(packet: TwoWayPingClientboundPlayPacket)

    fun onSetHotbar(packet: SetHotbarClientboundPlayPacket)

    fun onSetSpawnpoint(packet: SetSpawnpointClientboundPlayPacket)

    fun onVelocityControl(packet: VelocityControlClientboundPlayPacket)
}
