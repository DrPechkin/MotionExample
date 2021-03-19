package com.github.viktorvedernikov.motionlayout.presentation.common

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
fun Context.dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

const val LDPI: Int = DisplayMetrics.DENSITY_LOW
const val MDPI: Int = DisplayMetrics.DENSITY_MEDIUM
const val HDPI: Int = DisplayMetrics.DENSITY_HIGH

const val TVDPI: Int = DisplayMetrics.DENSITY_TV
const val XHDPI: Int = DisplayMetrics.DENSITY_XHIGH
const val XXHDPI: Int = DisplayMetrics.DENSITY_XXHIGH
const val XXXHDPI: Int = DisplayMetrics.DENSITY_XXXHIGH

const val MAXDPI: Int = 0xfffe

// returns dip(dp) dimension value in pixels
fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()

fun Context.dip(value: Float): Float = (value * resources.displayMetrics.density)

// return sp dimension value in pixels
fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()

fun Context.sp(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()

// converts px value into dip or sp
fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density

fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

fun Context.dimen(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)

// the same for the views
fun View.dip(value: Int): Int = context.dip(value)

fun View.dip(value: Float): Int = context.dip(value).toInt()
fun View.sp(value: Int): Int = context.sp(value)
fun View.sp(value: Float): Int = context.sp(value)
fun View.px2dip(px: Int): Float = context.px2dip(px)
fun View.px2sp(px: Int): Float = context.px2sp(px)
fun View.dimen(@DimenRes resource: Int): Int = context.dimen(resource)
fun View.float(@DimenRes resource: Int): Float {
    val outValue = TypedValue()
    resources.getValue(resource, outValue, true)
    return outValue.float
}

fun View.dipf(value: Int): Float = dip(value).toFloat()
fun View.dipf(value: Float): Float = context.dip(value)

fun RecyclerView.ViewHolder.dip(value: Int): Int =
    (value * itemView.context.resources.displayMetrics.density).toInt()

fun RecyclerView.ViewHolder.dip(value: Float): Int =
    (value * itemView.context.resources.displayMetrics.density).toInt()

fun Fragment.dip(value: Int): Int = requireContext().dip(value)
fun Fragment.dip(value: Float): Float = requireContext().dip(value)

fun Fragment.sp(value: Int): Int = requireContext().sp(value)
fun Fragment.sp(value: Float): Int = requireContext().sp(value)