package com.github.viktorvedernikov.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_scrolling.*

class MainFragment : Fragment() {

    private var motionLayout: MotionLayout? = null

    var c = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.activity_scrolling, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motionLayout = activity?.findViewById<MotionLayout>(R.id.motionLayout)
        btn?.setOnClickListener {
            if (c == 0) {
                c = 1
                motionLayout?.transitionToState(R.id.basketItemShown)
            } else {
                c = 0
                motionLayout?.transitionToState(R.id.basketItemHidden)
            }


        }
    }
}