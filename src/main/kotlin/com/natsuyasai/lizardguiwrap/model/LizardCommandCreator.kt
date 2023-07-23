package com.natsuyasai.lizardguiwrap.model

import java.text.Normalizer.Form

class LizardCommandCreator(
    private val language: String,
    private val format: String,
    private val fileName: String
) {

    fun getOptions(): String {
        var retOptionsStr = ""
        val formatOpt = convertOptionForFormat()
        var extension = ".txt"
        if (formatOpt != "") {
            retOptionsStr += "--${formatOpt} "
            extension = ".${formatOpt}"
        }
        val langOpt = convertOptionForLanguage()
        if (langOpt != ""){
            retOptionsStr += "-l ${langOpt} "
        }
        if (fileName != ""){
            retOptionsStr += "-o ${fileName}${extension} "
        }
        return retOptionsStr
    }

    fun convertOptionForLanguage(): String {
        for (lang in Language.values()) {
            if (language == lang.langName) {
                return lang.option
            }
        }
        return ""
    }

    fun convertOptionForFormat(): String {
        for (type in Format.values()) {
            if (format == type.typeName) {
                return type.option
            }
        }
        return ""
    }
}

enum class Language(val langName: String, val option: String) {
    AUTO("Auto", ""),
    C("C", "c"),
    CPP("C++", "cpp"),
    JAVA("Java", "java"),
    CSHARP("C#", "csharp"),
    JS("JavaScript", "javascript"),
    TS("TypeScript", "typescript"),
    OBJECTIVE_C("Objective-C", "objective-c"),
    SWIFT("Swift", "swift"),
    PYTHON("Python", "python"),
    RUBY("Ruby", "ruby"),
    TTCN_3("TTCN-3", "ttcn"),
    PHP("PHP", "php"),
    SCALA("Scala", "scala"),
    GDSCRIPT("GDScript", "GDScript"),
    GO("Golang", "go"),
    LUA("Lua", "lua"),
    RUST("Rust", "rust"),
    FORTRAN("Fortran", "fortran"),
    KOTLIN("Kotlin", "kotlin"),
    SOLIDITY("Solidity", "solidity"),
    ERLANG("Erlang", "erlang")
}

enum class Format(val typeName: String, val option: String) {
    HTML("HTML", "html"),
    CSV("CSV", "csv"),
    XML("XML", "xml")
}