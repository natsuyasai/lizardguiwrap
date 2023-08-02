package com.natsuyasai.lizardguiwrap.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class FormParameters {
    val filePathProperty = SimpleStringProperty("")
    var filePath: String by filePathProperty

    val selectedLanguageProperty = SimpleStringProperty("Auto")
    var selectedLanguage: String by selectedLanguageProperty

    val selectedFormatProperty = SimpleStringProperty("HTML")
    var selectedFormat: String by selectedFormatProperty

    val outputFileNameProperty = SimpleStringProperty("result")
    var outputFileName: String by outputFileNameProperty

    val canExecProperty = SimpleBooleanProperty(false)
    var canExec: Boolean by canExecProperty
}
