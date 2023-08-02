package com.natsuyasai.lizardguiwrap.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class FormParameters {
    val filePathProperty = SimpleStringProperty()
    var filePath by filePathProperty

    val selectedLanguageProperty = SimpleStringProperty("Auto")
    var selectedLanguage by selectedLanguageProperty

    val selectedFormatProperty = SimpleStringProperty("HTML")
    var selectedFormat by selectedFormatProperty

    val outputFileNameProperty= SimpleStringProperty("result")
    var outputFileName by outputFileNameProperty
}
