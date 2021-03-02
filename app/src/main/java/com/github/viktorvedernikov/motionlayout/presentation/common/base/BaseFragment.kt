package com.github.viktorvedernikov.motionlayout.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviBaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.ViewState

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutResId, container, false)

}