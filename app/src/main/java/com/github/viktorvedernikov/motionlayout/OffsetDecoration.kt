package com.github.viktorvedernikov.motionlayout

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

typealias VisibilityProvider = (position: Int, parent: RecyclerView) -> Boolean

class OffsetDecoration(
    private val visibilityProvider: VisibilityProvider,
    private val leftMargin: Int,
    private val topMargin: Int,
    private val rightMargin: Int,
    private val bottomMargin: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        rect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (!visibilityProvider.invoke(position, parent)) {
            return
        }
        rect.set(leftMargin, topMargin, rightMargin, bottomMargin)
    }

    class Builder {

        private var visibilityProvider: VisibilityProvider? = null
        private var leftMargin: Int = 0
        private var topMargin: Int = 0
        private var rightMargin: Int = 0
        private var bottomMargin: Int = 0

        fun visibilityProvider(provider: VisibilityProvider) =
            apply { visibilityProvider = provider }

        fun horizontal(margin: Int) = apply {
            leftMargin = margin
            rightMargin = margin
        }

        fun vertical(margin: Int) = apply {
            topMargin = margin
            bottomMargin = margin
        }

        fun left(margin: Int) = apply {
            leftMargin = margin
        }

        fun right(margin: Int) = apply {
            rightMargin = margin
        }

        fun top(margin: Int) = apply {
            topMargin = margin
        }

        fun bottom(margin: Int) = apply {
            bottomMargin = margin
        }

        fun margins(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) = apply {
            leftMargin = left
            topMargin = top
            rightMargin = right
            bottomMargin = bottom
        }

        fun build() = OffsetDecoration(
            visibilityProvider = visibilityProvider ?: { _, _ -> true },
            leftMargin = leftMargin,
            topMargin = topMargin,
            rightMargin = rightMargin,
            bottomMargin = bottomMargin
        )
    }
}