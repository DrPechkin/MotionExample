package com.github.viktorvedernikov.motionlayout

import android.graphics.Color
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topFrame.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View?, outline: Outline?) {
                    if (view != null && outline != null) {
                        outline.setRoundRect(0, 0, view.width, view.height, dpToPx(20f).toFloat())
                    }
                }
            }
            clipToOutline = true
        }
        motionLayout?.setBackgroundColor(Color.WHITE)
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
