package com.natsuyasai.lizardguiwrap.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LizardCommandCreatorTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @ParameterizedTest
    @CsvSource(value = [
        "Auto,''",
        "C,c",
        "C++,cpp",
        "Java,java",
        "C#,csharp",
        "JavaScript,javascript",
        "TypeScript,typescript",
        "Objective-C, objective-c",
        "Swift, swift",
        "Python, python",
        "Ruby, ruby",
        "TTCN-3, ttcn",
        "PHP, php",
        "Scala, scala",
        "GDScript, GDScript",
        "Golang, go",
        "Lua, lua",
        "Rust, rust",
        "Fortran, fortran",
        "Kotlin, kotlin",
        "Solidity, solidity",
        "Erlang, erlang"
    ])
    fun convertOptionForLanguage(input: String, expected: String) {
        val target = LizardCommandCreator(
            input,
            "",
            "")

        val result = target.convertOptionForLanguage()
        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(value = [
        "HTML,html",
        "CSV,csv",
        "XML,xml",
    ])
    fun convertOptionForFormat(input: String, expected: String) {
        val target = LizardCommandCreator(
            "",
            input,
            "")

        val result = target.convertOptionForFormat()
        Assertions.assertEquals(expected, result)
    }

}