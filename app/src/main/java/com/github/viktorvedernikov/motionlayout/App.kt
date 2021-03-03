package com.github.viktorvedernikov.motionlayout

import android.app.Application
import com.github.viktorvedernikov.motionlayout.presentation.common.base.routing.LocalCiceroneHolder

class App : Application() {

    companion object {
        val ciceroneHolder = LocalCiceroneHolder()
    }
}