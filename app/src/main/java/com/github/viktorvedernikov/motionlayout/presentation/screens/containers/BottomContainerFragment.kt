package com.github.viktorvedernikov.motionlayout.presentation.screens.containers

import android.os.Bundle
import android.view.View
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.screens.basket.BasketFragment

class BottomContainerFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_bottom_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.bottomContainerFrame, BasketFragment(), "BasketFragment")
                .commit()
        }
    }
}