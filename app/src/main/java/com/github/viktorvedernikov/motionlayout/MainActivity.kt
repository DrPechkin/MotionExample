package com.github.viktorvedernikov.motionlayout

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        motionLayout?.setBackgroundColor(Color.WHITE)
        motionLayout?.transitionToState(R.id.basketItemHidden)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.topFrame, MainFragment(), "MainFragment")
                .add(R.id.bottomFrame, BasketFragment(), "BasketFragment")
                .commit()
        }
    }
}
