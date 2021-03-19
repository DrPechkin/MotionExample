package com.github.viktorvedernikov.motionlayout.presentation.common

import android.os.SystemClock
import android.view.View

/**
 * Set OnClickListener callback with global in-app throttling manager. Prevent bugs connected with
 * multiple click.
 */
fun View.setOnDebouncedClickListener(action: () -> Unit) {
    val actionThrottlingManager = UnitActionThrottlingManager(action)

    // This is the only place in the project in the project where we should actually use setOnClickListener
    setOnClickListener {
        actionThrottlingManager.notifyAction()
    }
}

fun View.removeOnDebouncedClickListener() {
    setOnClickListener(null)
    isClickable = false
}

/**
 * Check if there are needed to invoke the callback by comparing current action time and last action
 * time.
 */
open class ActionThrottlingManager<T>(private val action: (T) -> Unit) {

    companion object {
        const val DEBOUNCE_INTERVAL_MILLISECONDS = 300L
        private var lastActionTime = 0L
    }

    fun notifyAction(arg: T) {
        val now = SystemClock.elapsedRealtime()

        val millisecondsPassed = now - lastActionTime
        val actionAllowed = millisecondsPassed > DEBOUNCE_INTERVAL_MILLISECONDS

        if (actionAllowed) {
            action(arg)
            lastActionTime = now
        }
    }
}

class UnitActionThrottlingManager(
    private val action: () -> Unit
) : ActionThrottlingManager<Unit>({ action() }) {
    fun notifyAction() {
        notifyAction(Unit)
    }
}
