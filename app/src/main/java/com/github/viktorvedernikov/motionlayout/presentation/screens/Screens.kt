package com.github.viktorvedernikov.motionlayout.presentation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.viktorvedernikov.motionlayout.presentation.screens.basket.BasketFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.main.MainFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.product.ProductDetailFragment

object Screens {

    fun getMain() = FragmentScreen { MainFragment() }

    fun getProductDetail() = FragmentScreen { ProductDetailFragment() }

    fun getBasket() = FragmentScreen { BasketFragment() }
}