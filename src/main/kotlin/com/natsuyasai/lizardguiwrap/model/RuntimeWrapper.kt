package com.natsuyasai.lizardguiwrap.model

import java.util.concurrent.TimeUnit


class RuntimeWrapper : ExternalProcessExecutor {

    private var isCancel: Boolean = false
    override fun exec(terminal: String, terminalOption: String, execFileName: String, option: String): Boolean {
        return try {
            val options = option.split(" ")
            val execCommand = (arrayListOf(terminal, terminalOption, execFileName) + options).filter { it.isNotEmpty() }
            val processBuilder = ProcessBuilder(execCommand)
            processBuilder.redirectError(ProcessBuilder.Redirect.DISCARD)
            processBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD)
            val process = processBuilder.start()
            val exitedProcess = wait(process)
            if(!exitedProcess) {
                killProcess(process)
            }
            process.destroy()
            process.exitValue() <= 0
        } catch (ex: Exception) {
            println(ex)
            false
        }
    }

    override fun cancel() {
        isCancel = true
    }

    private fun wait(process: Process): Boolean {
        var exited: Boolean
        do {
            exited = process.waitFor(5, TimeUnit.SECONDS)
        } while (!isCancel && !exited)
        return exited
    }

    private fun killProcess(process: Process) {
        process.descendants().forEach { processHandler -> processHandler.destroy() }
    }
}
