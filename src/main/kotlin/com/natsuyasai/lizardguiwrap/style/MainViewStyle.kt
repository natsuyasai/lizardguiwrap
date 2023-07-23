package com.natsuyasai.lizardguiwrap.style

import tornadofx.*

class MainViewStyle : Stylesheet() {

    companion object {
        val form by cssclass()
        val comboBox by cssclass()
        val text by cssclass()
        val separator by cssclass()
        val footerButton by cssclass()
    }

    init {
        form {
            prefWidth = 500.px
            minWidth = 500.px
            prefHeight = 310.px
            minHeight = 310.px
            maxHeight = 310.px
        }
        comboBox {
            prefWidth = 120.px
            fontSize = 14.px
        }

        text {
            fontSize = 14.px
        }

        separator {
            padding = box(16.px, 0.px, 16.px, 0.px)
        }

        footerButton {
            fontSize = 14.px
            prefWidth = 120.px
            prefHeight = 32.px
        }

    }
}