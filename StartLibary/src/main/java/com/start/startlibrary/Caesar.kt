package com.of.startofthegame

object Caesar {
    private val originalText = "nzzvy"
    private val shift = 6
    fun encryptCaesarCipher(text: String, shift: Int): String {
        val result = StringBuilder()
        val adjustedShift = shift % 26

        for (char in text) {
            when (char) {
                in 'A'..'Z' -> {
                    val shifted = char + adjustedShift
                    if (shifted > 'Z') {
                        result.append((shifted - 26).toChar())
                    } else if (shifted < 'A') {
                        result.append((shifted + 26).toChar())
                    } else {
                        result.append(shifted.toChar())
                    }
                }
                in 'a'..'z' -> {
                    val shifted = char + adjustedShift
                    if (shifted > 'z') {
                        result.append((shifted - 26).toChar())
                    } else if (shifted < 'a') {
                        result.append((shifted + 26).toChar())
                    } else {
                        result.append(shifted.toChar())
                    }
                }
                else -> result.append(char)
            }
        }
        return result.toString()
    }



    fun decryptCaesarCipher(text: String, shift: Int): String {
        return encryptCaesarCipher(text, -shift)
    }

    val st = decryptCaesarCipher(originalText, shift) + ":" + "//"
}