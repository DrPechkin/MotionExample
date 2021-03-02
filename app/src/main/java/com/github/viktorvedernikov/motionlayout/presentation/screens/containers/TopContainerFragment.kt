package com.github.viktorvedernikov.motionlayout.presentation.screens.containers

import android.os.Bundle
import android.util.Log
import android.view.View
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.screens.product.ProductDetailFragment

class TopContainerFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_top_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.topContainerFrame, ProductDetailFragment(), "ProductDetailFragment")
                .commit()
        }
    }

    override fun onBackPressed() {
        Log.e("TopFrame", "onBackPressed")
    }
}