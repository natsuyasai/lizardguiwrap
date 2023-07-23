package com.natsuyasai.lizardguiwrap

import com.natsuyasai.lizardguiwrap.style.MainViewStyle
import com.natsuyasai.lizardguiwrap.view.MainView
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch
import tornadofx.reloadStylesheetsOnFocus

class MainApplication : App(MainView::class, MainViewStyle::class) {
//    init {
//        reloadStylesheetsOnFocus()
//    }

    override fun start(stage: Stage) {
        with(stage) {
            isResizable = false
            minWidth = 500.0
            minHeight = 310.0
            super.start(this)
        }
    }
}

fun main(args: Array<String>) {
    launch<MainApplication>(args)
}