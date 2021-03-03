package com.github.viktorvedernikov.motionlayout.presentation.common.base

import android.os.Bundle
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.viktorvedernikov.motionlayout.App
import com.github.viktorvedernikov.motionlayout.R

abstract class FlowFragment : BaseFragment() {

    abstract val flowName: String
    abstract fun getLaunchScreen(): FragmentScreen

    private val localCiceroneHolder
        get() = App.ciceroneHolder

    private val cicerone
        get() = localCiceroneHolder.getCicerone(flowName)

    val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.layoutContainer) as? BaseFragment

    open val navigator: Navigator
        get() = AppNavigator(requireActivity(), R.id.layoutContainer, childFragmentManager)

    open fun toStartFlow() {
        router.newRootScreen(getLaunchScreen())
    }

    override val router: Router
        get() = cicerone.router

    override val layoutResId: Int = R.layout.layout_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            cicerone.router.newRootScreen(getLaunchScreen())
        }
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }
}