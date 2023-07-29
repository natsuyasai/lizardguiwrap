package com.natsuyasai.lizardguiwrap.model

import java.io.BufferedReader
import java.io.InputStreamReader


class RuntimeWrapper : ExternalProcessExecutor {
    override fun exec(terminal: String, terminalOption: String, execFileName: String, option: String): Boolean {
        return try {
            val options = option.split(" ")
            val execCommand = (arrayListOf(terminal, terminalOption, execFileName) + options).filter { it.isNotEmpty() }
            val processBuilder = ProcessBuilder(execCommand)
            val process = processBuilder.start()
            process.waitFor()
            process.destroy()
            process.exitValue() <= 0
        } catch (ex: Exception) {
            println(ex)
            false
        }
    }
}
