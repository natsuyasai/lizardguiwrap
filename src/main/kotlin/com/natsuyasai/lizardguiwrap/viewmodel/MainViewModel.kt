package com.natsuyasai.lizardguiwrap.viewmodel


import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.FXEvent
import tornadofx.ViewModel

class DirectorySelectEvent(val dir : String?) : FXEvent()
class MainViewModel : ViewModel() {

    val filePath = SimpleStringProperty()
    val selectedLanguage = SimpleStringProperty("Auto")
    val selectedFormat = SimpleStringProperty("HTML")
    val outputFileName = SimpleStringProperty("result")

    val languageItems: ObservableList<String> = FXCollections.observableArrayList(
        "Auto",
        "C/C++",
        "Java",
        "C#",
        "JavaScript",
        "TypeScript",
        "Objective-C",
        "Swift",
        "Python",
        "Ruby",
        "TTCN-3",
        "PHP",
        "Scala",
        "GDScript",
        "Golang",
        "Lua",
        "Rust",
        "Fortran",
        "Kotlin",
        "Solidity",
        "Erlang"
    )

    val formatItems: ObservableList<String> = FXCollections.observableArrayList(
        "HTML",
        "CSV",
        "XML",
    )

    init {
        // フォルダ選択イベント
        subscribe<DirectorySelectEvent> {
            filePath.value = it.dir
        }
    }

    fun execLizard() {
        // TODO コマンド実行
        // python -m lizard -l 選択した言語 -o 出力形式
    }
}