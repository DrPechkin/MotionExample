package com.github.viktorvedernikov.motionlayout.presentation.screens.containers

import android.util.Log
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.Screens

class TopContainerFragment : FlowFragment() {

    override val flowName: String
        get() = "TopFrame"

    override val layoutResId: Int = R.layout.layout_container

    override fun getLaunchScreen(): FragmentScreen = Screens.getMain()

    override fun onBackPressed() {
        super.onBackPressed()
        Log.e("TopFrame", "onBackPressed")
    }
}