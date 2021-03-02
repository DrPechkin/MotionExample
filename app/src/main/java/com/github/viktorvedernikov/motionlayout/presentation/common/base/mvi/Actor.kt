package com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class Actor<TIntent, TResult>(
    val scope: CoroutineScope,
    val action: suspend (param: TIntent) -> TResult,
    val reduction: (TIntent, TResult) -> Unit,
    val catch: (e: Throwable) -> Unit
) {
    fun run(intent: TIntent) {
        scope.launch {
            try {
                reduction(intent, action(intent))
            } catch (e: CancellationException) {
            } catch (e: Throwable) {
                catch(e)
            }
        }
    }
}

fun Actor<Unit, *>.run() {
    run(Unit)
}

fun <TIntent, TResult> ViewModel.actor(
    action: suspend (param: TIntent) -> TResult,
    reduction: (TIntent, TResult) -> Unit,
    catch: (e: Throwable) -> Unit
): Actor<TIntent, TResult> {
    return Actor(viewModelScope, action, reduction, catch)
}

interface UseCase<in TParams, out TResult> {
    suspend fun execute(params: TParams): TResult
}
