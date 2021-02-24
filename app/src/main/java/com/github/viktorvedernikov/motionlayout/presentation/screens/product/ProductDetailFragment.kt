package com.github.viktorvedernikov.motionlayout.presentation.screens.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.viktorvedernikov.motionlayout.*
import com.github.viktorvedernikov.motionlayout.presentation.common.OffsetDecoration
import com.github.viktorvedernikov.motionlayout.presentation.common.dpToPx
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {

    private var motionLayout: MotionLayout? = null

    private val listAdapter by lazy {
        ReviewsAdapter(ReviewsAdapter.Type.COMPONENT)
    }

    var c = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_product_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motionLayout = activity?.findViewById<MotionLayout>(R.id.motionLayout)
        btnBuy?.setOnClickListener {
            if (c == 0) {
                c = 1
                motionLayout?.transitionToState(R.id.basketItemShown)
                productDetailMotionLayout?.transitionToEnd()
            } else {
                c = 0
                motionLayout?.transitionToState(R.id.basketItemHidden)
            }
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