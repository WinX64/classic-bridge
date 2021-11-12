package dev.winx64.classicbridge.classic.cpe

data class ExtensionSettings(private val mutuallySupportedExtensions: Map<ExtensionType, Int>) {

    fun supports(extension: Pair<ExtensionType, Int>) = supports(extension.first, extension.second)

    fun supports(extensionType: ExtensionType, version: Int = 1) = mutuallySupportedExtensions[extensionType] == version

    fun getSupportedVersion(extensionType: ExtensionType) = mutuallySupportedExtensions[extensionType]

    class Builder {

        private val mutuallySupportedExtensions = mutableMapOf<ExtensionType, Int>()

        fun include(extensionName: String, version: Int) {
            val extension = ExtensionType.parseProtocolExtension(extensionName) ?: return
            if (extension.supportedVersion == version) {
                mutuallySupportedExtensions += Pair(extension, version)
            }
        }

        fun build() = ExtensionSettings(mutuallySupportedExtensions)
    }
}
