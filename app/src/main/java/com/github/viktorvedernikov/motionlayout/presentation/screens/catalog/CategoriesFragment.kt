package com.github.viktorvedernikov.motionlayout.presentation.screens.catalog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.github.terrakok.cicerone.Router
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.OffsetDecoration
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.FlowFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.base.mvi.MviBaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.dpToPx
import kotlinx.android.synthetic.main.fragment_catalog.*
import kotlinx.coroutines.flow.collectLatest

class CategoriesFragment : BaseFragment(),
    MviBaseFragment<CategoriesScreenViewState, CategoriesScreenViewIntent> {

    override val router: Router
        get() = (parentFragment as FlowFragment).router

    override val viewModel: CategoriesViewModel by viewModels()

    override val layoutResId: Int = R.layout.fragment_catalog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        lifecycleScope.launchWhenCreated {
            viewModel.stateFlow.collectLatest(::render)
        }
    }

    override suspend fun render(state: CategoriesScreenViewState) {
        when (state) {
            is CategoriesScreenViewState.Loaded -> {
                (rvCatalog.adapter as CategoriesAdapter).submitList(state.items)
            }
            CategoriesScreenViewState.Loading -> {

            }
        }
    }

    private fun initRecycler() {
        rvCatalog.apply {
            layoutManager = GridLayoutManager(context, 6).apply {
                spanSizeLookup = object  : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        val banner = (adapter as CategoriesAdapter).currentList[position]
                        return banner.weight
                    }
                }
            }
            addItemDecoration(
                OffsetDecoration.Builder()
                    .horizontal(dpToPx(4f))
                    .vertical(dpToPx(4f))
                    .build()
            )
            adapter = CategoriesAdapter()
        }
    }
}