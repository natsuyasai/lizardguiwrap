package com.natsuyasai.lizardguiwrap.viewmodel


import com.natsuyasai.lizardguiwrap.model.*
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.FXEvent
import tornadofx.ItemViewModel
import tornadofx.onChange

class DirectorySelectEvent(val dir: String?) : FXEvent()
class MainViewModel(private val parameters: FormParameters) : ItemViewModel<FormParameters>(parameters) {

    val filePath = bind(FormParameters::filePathProperty)
    val selectedLanguage = bind(FormParameters::selectedLanguageProperty)
    val selectedFormat = bind(FormParameters::selectedFormatProperty)
    val outputFileName = bind(FormParameters::outputFileNameProperty)
    val moreParameters = bind(FormParameters::moreParametersProperty)

    val canExec = bind(FormParameters::canExecProperty)
    val canCancel = bind(FormParameters::canCancelProperty)

    private var currentCommandExecutor: LizardCommandExecutor? = null

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
            parameters.filePath = it.dir ?: ""
        }
        filePath.onChange {
            onChangeFolderPath(it)
        }
        outputFileName.onChange {
            onChangeFileName(it)
        }
    }

    /**
     * コマンド実行
     */
    fun execLizard(): Boolean {
        parameters.canExec = false
        parameters.canCancel = true
        val lizardCommand = LizardCommandCreator(
            parameters.filePath,
            parameters.selectedLanguage,
            parameters.selectedFormat,
            parameters.outputFileName
        )
        currentCommandExecutor = LizardCommandExecutor(RuntimeWrapper(), lizardCommand)
        val ret = currentCommandExecutor!!.exec()
        parameters.canExec = true
        parameters.canCancel = false
        currentCommandExecutor = null
        return ret
    }

    fun cancel() {
        currentCommandExecutor?.cancel()
    }

    fun validateFileName(): Boolean {
        return FileNameValidator(outputFileName.value ?: "").validate()
    }

    private fun onChangeFolderPath(changedPath: String?) {
        if (changedPath.isNullOrBlank()) {
            parameters.canExec = false
        } else if (outputFileName.value.isNotBlank()) {
            parameters.canExec = true
        }
    }

    private fun onChangeFileName(changedName: String?) {
        if (changedName.isNullOrBlank()) {
            parameters.canExec = false
        } else if (filePath.value.isNotBlank()) {
            parameters.canExec = true
        }
        if (!FileNameValidator(changedName ?: "").validate()) {
            parameters.canExec = false
        }
    }
}
