package com.github.viktorvedernikov.motionlayout.presentation.screens.catalog

import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewIntent
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewState
import com.github.viktorvedernikov.motionlayout.presentation.models.Category

sealed class CategoriesScreenViewState : ViewState {
    data class Loaded(val items: List<Category>) : CategoriesScreenViewState()
    object Loading : CategoriesScreenViewState()
}

sealed class CategoriesScreenViewIntent : ViewIntent