package com.github.viktorvedernikov.motionlayout.presentation.screens.auth.code

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.databinding.FragmentConfirmCodeBinding
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.setOnDebouncedClickListener

class ConfirmCodeFragment : BaseFragment() {

    private val binding: FragmentConfirmCodeBinding by viewBinding()

    override val layoutResId: Int
        get() = R.layout.fragment_confirm_code

    override val router: Router
        get() = (parentFragment as FlowFragment).router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configView()
    }

    private fun configView() = with(binding) {

        btnBack.setOnDebouncedClickListener {
            router.exit()
        }

        tvRequestAgain.setOnDebouncedClickListener {

        }

        pinEdit.apply {
            doAfterTextChanged { s ->
                if (s.toString() == "1234") {

                } else if (s?.length == "1234".length) {
                    pinEdit.text = null
                }
            }
            requestFocus()
        }

    }

}