package com.github.viktorvedernikov.motionlayout.presentation.screens.basket

import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewState

sealed class BasketState : ViewState {
    object Loading : BasketState()
}