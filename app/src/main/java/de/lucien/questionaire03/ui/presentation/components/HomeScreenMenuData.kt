package de.lucien.questionaire03.ui.presentation.components

import de.lucien.questionaire03.DrawableStringPair
import de.lucien.questionaire03.R


val topMenuData = listOf(
    R.drawable.p1food to R.string.food,
    R.drawable.basicincome to R.string.basicIncome,
    R.drawable.p1humanrights to R.string.humanrights,
    R.drawable.p1trees to R.string.Nature,
    R.drawable.p1windpower to R.string.energy
).map{ DrawableStringPair(it.first, it.second) }

val middleMenuData = listOf(
    R.drawable.p1plastic to R.string.Plastic,
    R.drawable.p1climatewarming to R.string.climateWarming,
    R.drawable.p1desertification to R.string.desertification,
    R.drawable.p1recycling to R.string.recycling,
    R.drawable.p1trees to R.string.Trees,
    R.drawable.p1water to R.string.water,
    R.drawable.p1windpower to R.string.windPower
).map{ DrawableStringPair(it.first, it.second) }

