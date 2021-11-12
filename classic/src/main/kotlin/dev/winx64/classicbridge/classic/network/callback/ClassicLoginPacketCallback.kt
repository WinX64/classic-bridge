package dev.winx64.classicbridge.classic.network.callback

import dev.winx64.classicbridge.classic.network.clientbound.login.DisconnectPlayerClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.login.PingClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.login.ServerIdentificationClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.login.cpe.ExtensionEntryClientboundLoginPacket
import dev.winx64.classicbridge.classic.network.clientbound.login.cpe.ExtensionInfoClientboundLoginPacket

interface ClassicLoginPacketCallback : ClassicPacketCallback {

    fun onServerIdentification(packet: ServerIdentificationClientboundLoginPacket)

    fun onPing(packet: PingClientboundLoginPacket)

    fun onDisconnectPlayer(packet: DisconnectPlayerClientboundLoginPacket)

    fun onExtensionInfo(packet: ExtensionInfoClientboundLoginPacket)

    fun onExtensionEntry(packet: ExtensionEntryClientboundLoginPacket)
}
