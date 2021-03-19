package com.github.viktorvedernikov.motionlayout.presentation.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.util.*

fun Fragment.color(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(requireContext(), colorRes)

fun Context.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)
fun View.color(@ColorRes colorRes: Int): Int = context.color(colorRes)
fun View.colorStateList(@ColorRes colorRes: Int): ColorStateList? =
    ContextCompat.getColorStateList(context, colorRes)

fun Context.string(@StringRes stringRes: Int): String = getString(stringRes)
fun Context.string(@StringRes stringRes: Int, vararg args: Any): String =
    getString(stringRes).format(*args)

fun View.string(@StringRes stringRes: Int): String = context.getString(stringRes)
fun View.string(@StringRes stringRes: Int, vararg args: Any): String =
    context.getString(stringRes).format(*args)

fun Fragment.string(@StringRes stringRes: Int, vararg args: Any): String =
    context?.string(stringRes, *args) ?: ""

fun Context.integer(@IntegerRes integerRes: Int): Int = resources.getInteger(integerRes)
fun View.integer(@IntegerRes integerRes: Int): Int = context.integer(integerRes)

fun RecyclerView.ViewHolder.string(@StringRes stringRes: Int): String =
    itemView.context.getString(stringRes)

fun RecyclerView.ViewHolder.string(@StringRes stringRes: Int, vararg args: Any): String =
    itemView.context.getString(stringRes).format(*args)

fun RecyclerView.ViewHolder.color(@ColorRes colorRes: Int): Int =
    itemView.context.color(colorRes)

fun Fragment.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(requireContext(), drawableRes)

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(this, drawableRes)

fun View.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(context, drawableRes)

fun Fragment.tintDrawable(@DrawableRes drawableRes: Int, @ColorInt color: Int): Drawable? =
    drawable(drawableRes)?.tinted(color)

fun Context.tintDrawable(@DrawableRes drawableRes: Int, @ColorInt color: Int): Drawable? =
    drawable(drawableRes)?.tinted(color)

fun View.tintDrawable(@DrawableRes drawableRes: Int, @ColorInt color: Int): Drawable? =
    drawable(drawableRes)?.tinted(color)

fun Drawable.tinted(@ColorInt color: Int): Drawable {
    val wrapDrawable = DrawableCompat.wrap(this).mutate()
    DrawableCompat.setTint(wrapDrawable, color)
    return wrapDrawable
}

fun ViewGroup.inflate(@LayoutRes id: Int, attachToRoot: Boolean = true) =
    LayoutInflater.from(context).inflate(id, this, attachToRoot)

fun Context.inflate(@LayoutRes id: Int) =
    LayoutInflater.from(this).inflate(id, null, false)

