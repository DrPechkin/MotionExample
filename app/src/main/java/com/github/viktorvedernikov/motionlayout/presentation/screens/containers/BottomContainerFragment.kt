package com.github.viktorvedernikov.motionlayout.presentation.screens.containers

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.MainActivity
import com.github.viktorvedernikov.motionlayout.presentation.screens.Screens

class BottomContainerFragment : FlowFragment() {

    override val flowName: String
        get() = "BottomFlow"

    override val layoutResId: Int = R.layout.layout_container

    override fun getLaunchScreen(): FragmentScreen = Screens.getBasket()

    override fun onBackPressed() {
        // [parentFragmentManager.fragments] returns only distinct fragment classes and cannot be used for size counting
        if (parentFragmentManager.backStackEntryCount > 1) {
            currentFragment?.onBackPressed() ?: onBackPressed()
        } else {
            (activity as MainActivity).toggleBasketItemScene()
        }
    }
}