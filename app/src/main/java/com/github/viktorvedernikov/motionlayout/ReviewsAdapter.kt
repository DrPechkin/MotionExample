package com.github.viktorvedernikov.motionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer


data class Review(val id: Int = 0)

class ReviewsAdapter(
    private val type: Type = Type.LIST
) : ListAdapter<Review, ReviewsAdapter.ReviewViewHolder>(ReviewDiff()) {

    enum class Type(val value: Int) {
        COMPONENT(1), LIST(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        if (type == Type.COMPONENT) view.findViewById<TextView>(R.id.tvReviewDescription)?.maxLines = 7
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ReviewViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(review: Review) {
        }
    }

    class ReviewDiff : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean =
            oldItem == newItem
    }
}
