package com.natsuyasai.lizardguiwrap.model

import com.natsuyasai.lizardguiwrap.util.PlatformUtil

class LizardCommandExecutor(
    private val processExecutor: ExternalProcessExecutor,
    private val commandCreator: LizardCommandCreator) {

    private val windowsCommandBase = "/c python -m lizard"
    private val linuxCommandBase = "-c python3 -m lizard"

    fun exec(): Boolean {
        return processExecutor.exec(getTerminal(), getCurrentOSCommand(), commandCreator.getOptions())
    }

    private fun getTerminal(): String {
        return when {
            PlatformUtil.isWindows() -> "cmd"
            PlatformUtil.isLinux() -> "sh"
            PlatformUtil.isMac() -> "sh"
            else -> "cmd"
        }
    }
    private fun getCurrentOSCommand(): String {
        return when {
            PlatformUtil.isWindows() -> windowsCommandBase
            PlatformUtil.isLinux() -> linuxCommandBase
            PlatformUtil.isMac() -> linuxCommandBase
            else -> windowsCommandBase
        }
    }
}