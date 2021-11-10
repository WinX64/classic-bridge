package dev.winx64.classicbridge.classic.cpe

data class ExtensionSettings(private val mutuallySupportedExtensions: Map<ProtocolExtension, Int>) {

    fun supports(extension: ProtocolExtension, version: Int = 1) = mutuallySupportedExtensions[extension] == version

    fun getSupportedVersion(extension: ProtocolExtension) = mutuallySupportedExtensions[extension]

    class Builder {

        private val mutuallySupportedExtensions = mutableMapOf<ProtocolExtension, Int>()

        fun include(extensionName: String, version: Int) {
            val extension = ProtocolExtension.parseProtocolExtension(extensionName) ?: return
            if (extension.supportedVersion == version) {
                mutuallySupportedExtensions += Pair(extension, version)
            }
        }

        fun build() = ExtensionSettings(mutuallySupportedExtensions)
    }
}
