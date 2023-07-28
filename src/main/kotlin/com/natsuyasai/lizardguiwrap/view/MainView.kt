package com.natsuyasai.lizardguiwrap.view

import com.natsuyasai.lizardguiwrap.style.MainViewStyle
import com.natsuyasai.lizardguiwrap.viewmodel.DirectorySelectEvent
import com.natsuyasai.lizardguiwrap.viewmodel.MainViewModel
import javafx.scene.Parent
import javafx.scene.control.Alert
import tornadofx.*

class MainView : View("lizard gui wrap") {

    private val viewModel: MainViewModel by inject()

    override val root: Parent = form {
        addClass(MainViewStyle.form)
        // フォルダ選択
        fieldset {
            field("FilePath") {
                addClass(MainViewStyle.text)
                textfield(viewModel.filePath){
                    addClass(MainViewStyle.text)
                }
                button("select") {
                    action {
                        val dir = chooseDirectory("Select Folder",
                            owner = this@MainView.currentWindow)
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
                combobox(viewModel.selectedFormat, viewModel.formatItems){
                    addClass(MainViewStyle.comboBox)
                }
            }
        }
        // ファイル名
        fieldset {
            field("Output File Name") {
                addClass(MainViewStyle.text)
                textfield(viewModel.outputFileName){
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
                    button ("exec"){
                        addClass(MainViewStyle.footerButton)
                        action {
                            if (viewModel.execLizard()) {
                                alert(Alert.AlertType.INFORMATION,
                                    "Result",
                                    content = "Completed",
                                    title = "Info",
                                    owner = this@MainView.currentWindow)
                            } else {
                                alert(Alert.AlertType.INFORMATION,
                                    "Result",
                                    content = "Failed",
                                    title = "Error",
                                    owner = this@MainView.currentWindow)
                            }
                        }
                    }
                }
            }
        }
    }
}