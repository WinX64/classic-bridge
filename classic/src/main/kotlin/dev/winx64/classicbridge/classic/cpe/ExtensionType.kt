package dev.winx64.classicbridge.classic.cpe

/**
 * Classic Protocol Extensions supported by ClassicBridge
 * For an extension to be supported, it must be fully supported by the premium client
 */
enum class ExtensionType(val identifier: String, val supportedVersion: Int) {
    CLICK_DISTANCE("ClickDistance", 1),
    CUSTOM_BLOCKS("CustomBlocks", 1),
    HELD_BLOCK("HeldBlock", 1),
    EMOTE_FIX("EmoteFix", 1),

    //TEXT_HOT_KEY - The premium client has no support

    EXT_PLAYER_LIST("ExtPlayerList", 2),

    //ENV_COLORS - The premium client has no support
    //SELECTION_CUBOID - The premium client has no support

    BLOCK_PERMISSIONS("BlockPermissions", 1),

    //CHANGE_MODEL - The premium client has no support

    ENV_WEATHER_TYPE("EnvWeatherType", 1),

    //HACK_CONTROL - The premium client has partial support (no customizable jump, no 3rd-person disallowing)

    MESSAGE_TYPES("MessageTypes", 1),

    //PLAYER_CLICK - The premium client has partial support (no way to detect middle-click, no way to detect button release)

    LONGER_MESSAGES("LongerMessages", 1),
    FULL_CP437("FullCP437", 1),

    //BLOCK_DEFINITIONS - The premium client has partial support (no customizable collision, among other heavy limitations)
    //BLOCK_DEFINITIONS_EXT - Pointless, as BLOCK_DEFINITIONS is not supported

    BULK_BLOCK_UPDATE("BulkBlockUpdate", 1),
    TEXT_COLORS("TextColors", 1),
    ENV_MAP_ASPECT("EnvMapAspect", 1),

    //ENTITY_PROPERTY - Pointless, as CHANGE_MODEL is not supported

    EXT_ENTITY_POSITIONS("ExtEntityPositions", 1),
    TWO_WAY_PING("TwoWayPing", 1),

    //INVENTORY_ORDER - The premium client has no support

    INSTANT_MOTD("InstantMOTD", 1),

    //EXTENDED_BLOCKS - Pointless, as BLOCK_DEFINITIONS is not supported

    FAST_MAP("FastMap", 1),
    EXTENDED_TEXTURES("ExtendedTextures", 1),
    SET_HOTBAR("SetHotbar", 1),
    SET_SPAWNPOINT("SetSpawnpoint", 1),
    VELOCITY_CONTROL("VelocityControl", 1),

    //CUSTOM_PARTICLES - The premium client has no support
    //CUSTOM_MODELS_V2 - The premium client has no support
    ;

    companion object {
        private val BY_IDENTIFIER = values().associateBy { it.name }

        fun parseProtocolExtension(name: String) = BY_IDENTIFIER[name]
    }
}
