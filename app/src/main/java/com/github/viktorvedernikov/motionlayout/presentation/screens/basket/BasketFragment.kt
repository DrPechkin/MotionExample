package com.github.viktorvedernikov.motionlayout.presentation.screens.basket

import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.Router
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviBaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviViewModel

class BasketFragment : BaseFragment(), MviBaseFragment<BasketState, BasketIntent> {

    override val router: Router
        get() = (parentFragment as FlowFragment).router

    override val layoutResId: Int = R.layout.fragment_busket

    override val viewModel: MviViewModel<BasketState, BasketIntent> by viewModels()

    override suspend fun render(state: BasketState) {

    }
}