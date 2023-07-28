package com.natsuyasai.lizardguiwrap.viewmodel


import com.natsuyasai.lizardguiwrap.model.Format
import com.natsuyasai.lizardguiwrap.model.Language
import com.natsuyasai.lizardguiwrap.model.LizardCommandCreator
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.FXEvent
import tornadofx.ViewModel

class DirectorySelectEvent(val dir: String?) : FXEvent()
class MainViewModel : ViewModel() {

    val filePath = SimpleStringProperty()
    val selectedLanguage = SimpleStringProperty("Auto")
    val selectedFormat = SimpleStringProperty("HTML")
    val outputFileName = SimpleStringProperty("result")

    val languageItems: ObservableList<String> = FXCollections.observableArrayList(
        Language.AUTO.langName,
        Language.C.langName,
        Language.CPP.langName,
        Language.JAVA.langName,
        Language.CSHARP.langName,
        Language.JS.langName,
        Language.TS.langName,
        Language.OBJECTIVE_C.langName,
        Language.SWIFT.langName,
        Language.PYTHON.langName,
        Language.RUBY.langName,
        Language.TTCN_3.langName,
        Language.PHP.langName,
        Language.SCALA.langName,
        Language.GDSCRIPT.langName,
        Language.GO.langName,
        Language.LUA.langName,
        Language.RUST.langName,
        Language.FORTRAN.langName,
        Language.KOTLIN.langName,
        Language.SOLIDITY.langName,
        Language.ERLANG.langName
    )

    val formatItems: ObservableList<String> = FXCollections.observableArrayList(
        Format.HTML.typeName,
        Format.CSV.typeName,
        Format.XML.typeName
    )

    init {
        // フォルダ選択イベント
        subscribe<DirectorySelectEvent> {
            filePath.value = it.dir
        }
    }

    fun execLizard(): Boolean {
        // TODO
        // pythonの指定は外部からできるようにしておく
        // メッセージ表示
        val lizardCommand = LizardCommandCreator(selectedLanguage.value, selectedFormat.value, outputFileName.value)
        val runtime = Runtime.getRuntime()
        val command = arrayOf<String>("cmd", "/c", "python -m lizard ${lizardCommand.getOptions()}")
        return try {
            val process = runtime.exec(command)
            process.waitFor()
            process.destroy()
            true
        } catch (ex: Exception) {
            println(ex)
            false
        }
    }
}