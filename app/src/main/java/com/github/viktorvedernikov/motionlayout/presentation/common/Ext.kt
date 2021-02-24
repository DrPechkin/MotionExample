package com.github.viktorvedernikov.motionlayout.presentation.common

import android.content.Context
import android.util.TypedValue
import android.view.View

fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
fun Context.dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()