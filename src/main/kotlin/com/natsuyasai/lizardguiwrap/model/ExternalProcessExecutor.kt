package com.natsuyasai.lizardguiwrap.model

interface ExternalProcessExecutor {
    fun exec(terminal: String, command: String, option: String): Boolean
}