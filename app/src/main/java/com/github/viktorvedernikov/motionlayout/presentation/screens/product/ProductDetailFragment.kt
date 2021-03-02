package com.github.viktorvedernikov.motionlayout.presentation.screens.product

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.viktorvedernikov.motionlayout.*
import com.github.viktorvedernikov.motionlayout.presentation.common.OffsetDecoration
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.dpToPx
import com.github.viktorvedernikov.motionlayout.presentation.screens.MainActivity
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : BaseFragment() {

    private val listAdapter by lazy {
        ReviewsAdapter(ReviewsAdapter.Type.COMPONENT)
    }

    override val layoutResId: Int = R.layout.fragment_product_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBuy?.setOnClickListener {
            (activity as? MainActivity?)?.toggleBasketItemScene()
        }
        reviewsComponent.findViewById<TextView>(R.id.tvTitle)?.apply {
            text = "Отзывы"
            setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.topFrame, ReviewsFragment(), "ReviewsFragment")
                    ?.addToBackStack("ReviewsFragment")
                    ?.commit()
            }
        }
        reviewsComponent.findViewById<TextView>(R.id.tvCountItems)?.apply {
            text = "3"
            setOnClickListener {
                findViewById<TextView>(R.id.tvTitle)?.performClick()
            }
        }
        reviewsComponent.findViewById<RecyclerView>(R.id.rvItems)?.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            addItemDecoration(
                OffsetDecoration.Builder()
                    .right(dpToPx(16f))
                    .build()
            )
        }
        listAdapter.submitList(listOf(Review(), Review(1), Review(2)))
    }

}