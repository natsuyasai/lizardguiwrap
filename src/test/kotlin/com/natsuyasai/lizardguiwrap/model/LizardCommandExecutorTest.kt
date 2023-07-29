@file:Suppress("NonAsciiCharacters")

package com.natsuyasai.lizardguiwrap.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.mock
import org.mockito.kotlin.*

class LizardCommandExecutorTest {

    private val processExecutor: ExternalProcessExecutor = mock()
    private val currentOsName = System.getProperty("os.name")

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
        System.setProperty("os.name", currentOsName)
    }

    @Test
    fun Windows環境でのコマンド実行確認() {
        System.setProperty("os.name", "Windows")
        val commandCreator = LizardCommandCreator("","HTML","result")
        val target = LizardCommandExecutor(processExecutor, commandCreator)
        whenever(processExecutor.exec(any(), any(), any(), any())).thenReturn(true)

        val ret = target.exec()

        assertEquals(true, ret)
        verify(processExecutor, times(1))
            .exec("cmd", "/c", "basecommand.bat", "--html -o result.html")
    }

    @Test
    fun Mac環境でのコマンド実行確認() {
        System.setProperty("os.name", "Macos")
        val commandCreator = LizardCommandCreator("","HTML","result")
        val target = LizardCommandExecutor(processExecutor, commandCreator)
        whenever(processExecutor.exec(any(), any(), any(), any())).thenReturn(true)

        val ret = target.exec()

        assertEquals(true, ret)
        verify(processExecutor, times(1))
            .exec("sh", "-c", "basecommand.sh", "--html -o result.html")
    }

    @Test
    fun Linux環境でのコマンド実行確認() {
        System.setProperty("os.name", "Linux")
        val commandCreator = LizardCommandCreator("","HTML","result")
        val target = LizardCommandExecutor(processExecutor, commandCreator)
        whenever(processExecutor.exec(any(), any(), any(), any())).thenReturn(true)

        val ret = target.exec()

        assertEquals(true, ret)
        verify(processExecutor, times(1))
            .exec("sh", "-c", "basecommand.sh", "--html -o result.html")
    }
}
