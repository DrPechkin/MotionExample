package com.github.viktorvedernikov.motionlayout.presentation.screens.catalog

import com.github.viktorvedernikov.motionlayout.presentation.common.base.BaseViewModel
import com.github.viktorvedernikov.motionlayout.presentation.models.Category

class CategoriesViewModel : BaseViewModel<CategoriesScreenViewState, CategoriesScreenViewIntent>() {

    override val initialState: CategoriesScreenViewState
        get() = CategoriesScreenViewState.Loading

    init {
        state = CategoriesScreenViewState.Loaded(
            items = listOf(
                Category(
                    name = "Молоко, сыр, яйца",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Овощи, фрукты, грибы",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Птица и мясные изделия",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Рыба и морепродукты",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Хлеб и выпечка",
                    weight = 6,
                    height = 2
                ),
                Category(
                    name = "Сладость",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Соки, воды, напитки",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Замороженные продукты",
                    weight = 6,
                    height = 2
                ),
                Category(
                    name = "Бакалея",
                    weight = 2,
                    height = 3
                ),
                Category(
                    name = "Кофе, чай, какао",
                    weight = 2,
                    height = 3
                ),
                Category(
                    name = "Соусы, приправы",
                    weight = 2,
                    height = 3
                ),
                Category(
                    name = "Орехи, семечки, сухофрукты",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Для животных",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Красота и гигиена",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Для дома",
                    weight = 3,
                    height = 3
                ),
                Category(
                    name = "Алкогольные напитки",
                    weight = 6,
                    height = 2
                ),
                Category(
                    name = "Чипсы и снеки",
                    weight = 6,
                    height = 2
                ),
                Category(
                    name = "Здоровое питание",
                    weight = 3,
                    height = 2
                ),
                Category(
                    name = "У кассы",
                    weight = 3,
                    height = 2
                )
            )
        )
    }
}