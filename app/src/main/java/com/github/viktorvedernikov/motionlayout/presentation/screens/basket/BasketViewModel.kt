package com.github.viktorvedernikov.motionlayout.presentation.screens.basket

import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseViewModel
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviViewModel
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewIntent
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewState

class BasketViewModel : BaseViewModel<BasketState, BasketIntent>() {

    override val initialState: BasketState = BasketState.Loading

}
