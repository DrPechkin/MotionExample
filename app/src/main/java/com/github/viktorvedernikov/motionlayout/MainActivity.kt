package com.github.viktorvedernikov.motionlayout

import android.graphics.Color
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private var lastProgress = 0f
    private var topFrameRadiusCorner = 20f
        get() = dpToPx(field).toFloat()

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
        motionLayout?.setTransitionListener(this)
        motionLayout?.transitionToState(R.id.basketItemHidden)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.topFrame, ProductDetailFragment(), "ProductDetailFragment")
                .add(R.id.bottomFrame, BasketFragment(), "BasketFragment")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (motionLayout?.currentState == R.id.basketShown) {
            motionLayout?.transitionToState(R.id.basketItemShown)
        } else {
            super.onBackPressed()
        }
    }
}
