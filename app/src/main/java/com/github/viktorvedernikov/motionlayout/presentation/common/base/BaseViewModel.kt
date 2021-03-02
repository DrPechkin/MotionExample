package com.github.viktorvedernikov.motionlayout.presentation.common.base

import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviViewModel
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewState

abstract class BaseViewModel<S : ViewState, Intent> : MviViewModel<S, Intent>()