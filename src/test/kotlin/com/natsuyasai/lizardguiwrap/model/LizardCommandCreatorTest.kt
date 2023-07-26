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
        "Auto,HTML,result,--html -o result.html ",
        "Auto,CSV,result,--csv -o result.csv ",
        "Auto,XML,result,--xml -o result.xml ",
        "C,HTML,result,--html -l c -o result.html ",
        "C++,HTML,result,--html -l cpp -o result.html ",
        "Java,HTML,result,--html -l java -o result.html ",
        "C#,HTML,result,--html -l csharp -o result.html ",
        "JavaScript,HTML,result,--html -l javascript -o result.html ",
        "TypeScript,HTML,result,--html -l typescript -o result.html ",
        "Objective-C,HTML,result,--html -l objective-c -o result.html ",
        "Swift,HTML,result,--html -l swift -o result.html ",
        "Python,HTML,result,--html -l python -o result.html ",
        "Ruby,HTML,result,--html -l ruby -o result.html ",
        "TTCN-3,HTML,result,--html -l ttcn -o result.html ",
        "PHP,HTML,result,--html -l php -o result.html ",
        "Scala,HTML,result,--html -l scala -o result.html ",
        "GDScript,HTML,result,--html -l GDScript -o result.html ",
        "Golang,HTML,result,--html -l go -o result.html ",
        "Lua,HTML,result,--html -l lua -o result.html ",
        "Rust,HTML,result,--html -l rust -o result.html ",
        "Fortran,HTML,result,--html -l fortran -o result.html ",
        "Kotlin,HTML,result,--html -l kotlin -o result.html ",
        "Solidity,HTML,result,--html -l solidity -o result.html ",
        "Erlang,HTML,result,--html -l erlang -o result.html "
    ])
    fun getOptions(language: String, format: String, fileName: String, expected: String) {
        val target = LizardCommandCreator(
            language,
            format,
            fileName)

        val result = target.getOptions()
        Assertions.assertEquals(expected, result)
    }

}