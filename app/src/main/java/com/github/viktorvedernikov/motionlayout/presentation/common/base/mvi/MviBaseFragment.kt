package com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi

import android.util.Log

interface ViewState

interface ViewIntent

interface MviBaseFragment<S : ViewState, I> {

    val state: S get() = viewModel.stateFlow.value
    val viewModel: MviViewModel<S, I>

    suspend fun render(state: S)

    fun I.send() {
        if (!viewModel.intents.offer(this)) {
            Log.e("$this", "Cannot send intent $this to viewModel: channel overflow")
        }
    }
}