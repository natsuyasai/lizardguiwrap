package com.natsuyasai.lizardguiwrap.model

import com.natsuyasai.lizardguiwrap.util.PlatformUtil

class LizardCommandExecutor(
    private val processExecutor: ExternalProcessExecutor,
    private val commandCreator: LizardCommandCreator) {

    private val execFileNameForWindows = "command\\basecommand.bat"
    private val execFileNameForLinux = "command/basecommand.sh"

    fun exec(): Boolean {
        return processExecutor.exec(
            getTerminal(),
            getTerminalOption(),
            getExecFileName(),
            commandCreator.getOptions())
    }

    private fun getTerminal(): String {
        return when {
            PlatformUtil.isWindows() -> "cmd"
            PlatformUtil.isLinux() -> "sh"
            PlatformUtil.isMac() -> "sh"
            else -> "cmd"
        }
    }
    private fun getTerminalOption(): String {
        return when {
            PlatformUtil.isWindows() -> "/c"
            PlatformUtil.isLinux() -> "-c"
            PlatformUtil.isMac() -> "-c"
            else -> "/c"
        }
    }
    private fun getExecFileName(): String {
        return when {
            PlatformUtil.isWindows() -> execFileNameForWindows
            PlatformUtil.isLinux() -> execFileNameForLinux
            PlatformUtil.isMac() -> execFileNameForLinux
            else -> execFileNameForWindows
        }
    }
}
