package com.github.viktorvedernikov.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_reviews.*

class ReviewsFragment : Fragment() {

    private val listAdapter: ReviewsAdapter by lazy {
        ReviewsAdapter(ReviewsAdapter.Type.LIST)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = layoutInflater.inflate(R.layout.fragment_reviews, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvReviews.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = listAdapter
            addItemDecoration(
                OffsetDecoration.Builder()
                    .bottom(dpToPx(16f))
                    .build()
            )
        }

        listAdapter.submitList(listOf(Review(), Review(1), Review(2)))
    }
}