package com.github.viktorvedernikov.motionlayout.presentation.common.base

interface ErrorHandler {
    fun proceed(error: Throwable): String?
}