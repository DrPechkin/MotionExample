package com.github.viktorvedernikov.motionlayout.presentation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.viktorvedernikov.motionlayout.presentation.screens.auth.code.ConfirmCodeFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.auth.phone.ConfirmPhoneFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.basket.BasketFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.catalog.CategoriesFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.main.MainFragment
import com.github.viktorvedernikov.motionlayout.presentation.screens.product.ProductDetailFragment

object Screens {

    fun getMain() = FragmentScreen { MainFragment() }

    fun getCategories() = FragmentScreen { CategoriesFragment() }

    fun getProductDetail() = FragmentScreen { ProductDetailFragment() }

    fun getBasket() = FragmentScreen { BasketFragment() }

    //Auth
    fun getConfirmPhoneScreen() = FragmentScreen { ConfirmPhoneFragment() }
    fun getConfirmCodeScreen() = FragmentScreen { ConfirmCodeFragment() }

}