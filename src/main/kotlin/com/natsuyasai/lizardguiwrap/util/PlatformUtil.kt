package com.natsuyasai.lizardguiwrap.util

import java.util.*

class PlatformUtil {
    companion object {
        fun isLinux(): Boolean {
            return System.getProperty("os.name")
                .lowercase(Locale.getDefault())
                .startsWith("linux")
        }

        fun isMac(): Boolean {
            return System.getProperty("os.name")
                .lowercase(Locale.getDefault())
                .startsWith("mac")
        }

        fun isWindows(): Boolean {
            return System.getProperty("os.name")
                .lowercase(Locale.getDefault())
                .startsWith("win")
        }
    }
}