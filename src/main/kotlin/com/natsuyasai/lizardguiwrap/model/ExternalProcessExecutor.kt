package com.natsuyasai.lizardguiwrap.model

interface ExternalProcessExecutor {
    fun exec(terminal: String, terminalOption: String, execFileName: String, option: String): Boolean
}
