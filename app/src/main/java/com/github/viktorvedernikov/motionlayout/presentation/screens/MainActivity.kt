package com.github.viktorvedernikov.motionlayout.presentation.screens

import android.graphics.Color
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.github.viktorvedernikov.motionlayout.R
import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseFragment
import com.github.viktorvedernikov.motionlayout.presentation.common.dpToPx
import com.github.viktorvedernikov.motionlayout.presentation.screens.containers.BottomContainerFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.containers.TopContainerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private var lastProgress = 0f
    private var topFrameRadiusCorner = 20f
        get() = dpToPx(field).toFloat()

    private lateinit var topContainerFragment: BaseFragment
    private lateinit var bottomContainerFragment: BaseFragment

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
        topFrame?.clipToOutline = true
        motionLayout?.setBackgroundColor(Color.parseColor("#666666"))
    }

    override fun onTransitionChange(p0: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        if (progress - lastProgress > 0) {
            // from start to end
            val atEnd = abs(progress - 1f) < 0.1f
            if (atEnd) {

            }
        } else {
            // from end to start
            val atStart = progress < 0.9f
            if (atStart) {

            }
        }
    }

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
        if (currentId == R.id.basketItemHidden) {
            motionLayout?.setBackgroundColor(Color.WHITE)
            topFrame?.clipToOutline = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applyOutlineProvider()
        motionLayout?.setTransitionListener(this)
        motionLayout?.transitionToState(R.id.basketItemHidden)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.topFrame,
                    TopContainerFragment().also {
                        topContainerFragment = it
                    },
                    "TopFrame"
                )
                .add(
                    R.id.bottomFrame,
                    BottomContainerFragment().also {
                        bottomContainerFragment = it
                    },
                    "BottomFrame"
                )
                .commit()
        }
    }

    override fun onBackPressed() {
        if (motionLayout?.currentState == R.id.bottomContainerShown) {
            bottomContainerFragment.onBackPressed()
        } else {
            topContainerFragment.onBackPressed()
        }
    }

    fun toggleBasketItemScene() {
        if (motionLayout?.currentState == R.id.basketItemShown)
            motionLayout?.transitionToState(R.id.basketItemHidden)
        else
            motionLayout?.transitionToState(R.id.basketItemShown)
    }

    private fun applyOutlineProvider() {
        topFrame.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View?, outline: Outline?) {
                    if (view != null && outline != null) {
                        outline.setRoundRect(
                            0,
                            -topFrameRadiusCorner.toInt(),
                            view.width,
                            view.height,
                            topFrameRadiusCorner
                        )
                    }
                }
            }
            clipToOutline = true
        }
    }
}
