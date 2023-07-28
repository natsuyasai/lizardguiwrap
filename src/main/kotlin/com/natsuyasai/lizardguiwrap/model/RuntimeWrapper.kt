package com.natsuyasai.lizardguiwrap.model

import java.io.BufferedReader
import java.io.InputStreamReader


class RuntimeWrapper : ExternalProcessExecutor {
    override fun exec(terminal: String, command: String, option: String): Boolean {
        try {
            val processBuilder = ProcessBuilder("cmd", "/c", "python -m lizard $option")
            val process = processBuilder.start()
            process.waitFor()
            process.destroy()
            return true
        } catch (ex: Exception) {
            println(ex)
            return false
        }
    }
}