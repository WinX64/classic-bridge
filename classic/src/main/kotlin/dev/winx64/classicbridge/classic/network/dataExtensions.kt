package dev.winx64.classicbridge.classic.network

import io.netty.buffer.ByteBuf

const val STRING_SIZE = 64
const val STRING_PADDING_CHARACTER = ' '
const val BYTE_ARRAY_SIZE = 1024

fun ByteBuf.readString() = ByteArray(STRING_SIZE).also { readBytes(it) }.toString(Charsets.US_ASCII).trimEnd()

fun ByteBuf.writeString(value: String): ByteBuf = this.also {
    require(value.length <= STRING_SIZE) { "String maximum size is $STRING_SIZE, got ${value.length}" }
    val stringBytes = value.padEnd(STRING_SIZE, STRING_PADDING_CHARACTER).toByteArray(Charsets.US_ASCII)
    writeBytes(stringBytes)
}

fun ByteBuf.readByteArray(size: Int = BYTE_ARRAY_SIZE) = ByteArray(size).also { readBytes(it) }

fun ByteBuf.writeByteArray(value: ByteArray): ByteBuf = this.also {
    require(value.size == BYTE_ARRAY_SIZE) { "Byte array size must be $BYTE_ARRAY_SIZE, got ${value.size}" }
    writeBytes(value)
}

fun ByteBuf.readIntArray(size: Int) = IntArray(size) { readInt() }

inline fun <reified T : Enum<T>> ByteBuf.readByteEnum(): T = T::class.java.enumConstants[readByte().toInt()]

fun <T : Enum<T>> ByteBuf.writeByteEnum(value: T) = this.also {
    writeByte(value.ordinal)
}

fun Int.hexString() = String.format("0x%02x", this).uppercase()
