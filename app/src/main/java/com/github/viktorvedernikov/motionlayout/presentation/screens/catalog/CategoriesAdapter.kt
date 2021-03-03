package com.github.viktorvedernikov.motionlayout.presentation.screens.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.models.Category
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesAdapter : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(
    object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.name == newItem.name
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.containerView.tvCategoryName.text = getItem(position).name
    }

    class CategoryViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer
}