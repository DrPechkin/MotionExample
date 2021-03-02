package com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.viktorvedernikov.motionlayout.presentation.common.base.ErrorHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

abstract class MviViewModel<S : ViewState, Intent>(
    //protected val errorHandler: ErrorHandler
) : ViewModel() {

    protected open val _state: MutableStateFlow<S> by lazy {
        MutableStateFlow(initialState)
    }

    protected open var state: S
        get() = stateFlow.value
        set(value) {
            _state.value = value
        }

    protected abstract val initialState: S

    val stateFlow: StateFlow<S> get() = _state
    val intents = Channel<Intent>(Channel.UNLIMITED)

    protected open var showErrorOnlyInLog = false

    open fun onError(throwable: Throwable) {
        //throwable.logError()
//        errorHandler.proceed(throwable)?.let { message ->
//            if (message.isNotEmpty() && !showErrorOnlyInLog) {
//                //showRequestError(message)
//            }
//        }
    }

    protected fun <TIntent> TIntent.delegateTo(handle: suspend (TIntent) -> Unit) {
        viewModelScope.launch {
            try {
                handle(this@delegateTo)
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    protected fun <TIntent, TEffect> TIntent.delegateTo(
        handle: suspend (TIntent) -> TEffect,
        reduction: suspend (Result<TEffect>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                reduction(
                    Result.success(handle(this@delegateTo))
                )
            } catch (e: Throwable) {
                onError(e)
                reduction(
                    Result.failure(e)
                )
            }
        }
    }


    // maybe there's suitable native implementation, but consumeAsFlow doesn't fit
    protected fun <TEffect> Channel<TEffect>.toEffectFlow(): Flow<TEffect> {
        return flow {
            for (i in this@toEffectFlow) {
                emit(i)
            }
        }
    }
}