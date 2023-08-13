package com.natsuyasai.lizardguiwrap.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

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
        "C:\\Users\\user\\Desktop\\Src,Auto,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Auto,CSV,result,'',C:\\Users\\user\\Desktop\\Src --csv -o result.csv",
        "C:\\Users\\user\\Desktop\\Src,Auto,XML,result,'',C:\\Users\\user\\Desktop\\Src --xml -o result.xml",
        "C:\\Users\\user\\Desktop\\Src,C,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l c -o result.html",
        "C:\\Users\\user\\Desktop\\Src,C++,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l cpp -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Java,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l java -o result.html",
        "C:\\Users\\user\\Desktop\\Src,C#,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l csharp -o result.html",
        "C:\\Users\\user\\Desktop\\Src,JavaScript,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l javascript -o result.html",
        "C:\\Users\\user\\Desktop\\Src,TypeScript,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l typescript -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Objective-C,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l objective-c -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Swift,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l swift -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Python,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l python -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Ruby,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l ruby -o result.html",
        "C:\\Users\\user\\Desktop\\Src,TTCN-3,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l ttcn -o result.html",
        "C:\\Users\\user\\Desktop\\Src,PHP,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l php -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Scala,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l scala -o result.html",
        "C:\\Users\\user\\Desktop\\Src,GDScript,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l GDScript -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Golang,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l go -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Lua,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l lua -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Rust,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l rust -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Fortran,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l fortran -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Kotlin,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l kotlin -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Solidity,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l solidity -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Erlang,HTML,result,'',C:\\Users\\user\\Desktop\\Src --html -l erlang -o result.html",
        "C:\\Users\\user\\Desktop\\Src,Auto,HTML,result,'-C 10',C:\\Users\\user\\Desktop\\Src --html -o result.html -C 10",
    ])
    fun 入力値に対してlizard用のコマンド形式に変換されたものが取得できること(folderPath: String, language: String, format: String, fileName: String, moreParameter: String, expected: String) {
        val target = LizardCommandCreator(
            folderPath,
            language,
            format,
            fileName,
            moreParameter)

        val result = target.getOptions()
        Assertions.assertEquals(expected, result)
    }
}
