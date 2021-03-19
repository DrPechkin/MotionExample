package com.github.viktorvedernikov.motionlayout.presentation.screens.auth.phone

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.databinding.FragmentConfirmPhoneBinding
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.setOnDebouncedClickListener
import com.github.viktorvedernikov.motionlayout.presentation.screens.Screens


class ConfirmPhoneFragment : BaseFragment() {

    private val binding: FragmentConfirmPhoneBinding by viewBinding()

    override val layoutResId: Int
        get() = R.layout.fragment_confirm_phone

    override val router: Router
        get() = (parentFragment as FlowFragment).router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
    }

    private fun configView() = with(binding) {
        editPhone.apply {
            setBackgroundResource(android.R.color.transparent)
            doAfterTextChanged {

            }
        }
        btnClose.setOnDebouncedClickListener {
            router.exit()
        }
        btnContinue.setOnDebouncedClickListener {
            router.navigateTo(Screens.getConfirmCodeScreen())
        }

    }
}