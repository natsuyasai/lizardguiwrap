package com.natsuyasai.lizardguiwrap.model

class FileNameValidator(private val fileName: String) {

    companion object {
        val PROHIBITED_SYMBOLS = Regex("""[\\/:*?<>|"]""")

        val PROHIBITED_CHARACTERS = arrayOf(
            "CON", "PRN", "AUX", "CLOCK$", "NUL",
            "COM0", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
            "LPT0", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"
        )

        const val MAX_LENGTH = 255
    }

    fun validate(): Boolean {
        if (fileName.length >= MAX_LENGTH) {
            return false
        }
        if (fileName.contains(PROHIBITED_SYMBOLS)) {
            return false
        }
        if (PROHIBITED_CHARACTERS.any { item -> item.lowercase() == fileName.lowercase() }) {
            return false
        }
        return true
    }
}
