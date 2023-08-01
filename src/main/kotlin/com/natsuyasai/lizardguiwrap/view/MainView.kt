package com.natsuyasai.lizardguiwrap.view

import com.natsuyasai.lizardguiwrap.style.MainViewStyle
import com.natsuyasai.lizardguiwrap.viewmodel.DirectorySelectEvent
import com.natsuyasai.lizardguiwrap.viewmodel.MainViewModel
import javafx.scene.Parent
import javafx.scene.control.Alert
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tornadofx.*


class MainView : View("lizard gui wrap") {

    private val viewModel: MainViewModel by inject()

    @OptIn(DelicateCoroutinesApi::class)
    override val root: Parent = form {
        addClass(MainViewStyle.form)
        // フォルダ選択
        fieldset {
            field("FilePath") {
                addClass(MainViewStyle.text)
                textfield(viewModel.filePath) {
                    addClass(MainViewStyle.text)
                }
                button("select") {
                    action {
                        val dir = chooseDirectory(
                            "Select Folder",
                            owner = this@MainView.currentWindow
                        )
                        println(dir)
                        fire(DirectorySelectEvent(dir?.absolutePath))
                    }
                }
            }
        }
        // 言語選択
        fieldset {
            field("Language") {
                addClass(MainViewStyle.text)
                combobox(viewModel.selectedLanguage, viewModel.languageItems) {
                    addClass(MainViewStyle.comboBox)
                }
            }
        }
        // 出力形式選択
        fieldset {
            field("Format") {
                addClass(MainViewStyle.text)
                combobox(viewModel.selectedFormat, viewModel.formatItems) {
                    addClass(MainViewStyle.comboBox)
                }
            }
        }
        // ファイル名
        fieldset {
            field("Output File Name") {
                addClass(MainViewStyle.text)
                textfield(viewModel.outputFileName) {
                    addClass(MainViewStyle.text)
                }
            }
        }
        separator {
            addClass(MainViewStyle.separator)
        }
        // 実行ボタン
        fieldset {
            borderpane {
                right {
                    button("exec") {
                        addClass(MainViewStyle.footerButton)
                        action {
                            GlobalScope.launch(Dispatchers.IO) {
                                val result = viewModel.execLizard()
                                GlobalScope.launch(Dispatchers.Main) {
                                    if (result) {
                                        alert(
                                            Alert.AlertType.INFORMATION,
                                            "Result",
                                            content = "Completed",
                                            title = "Info",
                                            owner = this@MainView.currentWindow
                                        )
                                    } else {
                                        alert(
                                            Alert.AlertType.ERROR,
                                            "Result",
                                            content = "Failed",
                                            title = "Error",
                                            owner = this@MainView.currentWindow
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
