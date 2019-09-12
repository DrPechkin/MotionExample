package com.github.viktorvedernikov.motionlayout

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlin.math.abs

class BasketFragment : Fragment(), MotionLayout.TransitionListener {

    private var lastProgress = 0f
    private var motionLayout: MotionLayout? = null

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
//        ivF.isVisible = false
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
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_busket, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motionLayout = activity?.findViewById<MotionLayout>(R.id.motionLayout)?.also {
            it.setTransitionListener(this)
        }
    }
}