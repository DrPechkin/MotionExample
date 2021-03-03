package com.github.viktorvedernikov.motionlayout.presentation.screens.main

import android.os.Bundle
import android.view.View
import com.github.terrakok.cicerone.Router
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.Screens
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override val router: Router
        get() = (parentFragment as FlowFragment).router

    override val layoutResId: Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            router.navigateTo(Screens.getProductDetail())
        }
    }
}