package dev.lantt.silentmoon.meditate

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockMeditationCategories {
    val categories = listOf(
        MeditationCategory(
            icon = R.drawable.ic_category_all,
            label = R.string.categoryAll
        ),
        MeditationCategory(
            icon = R.drawable.ic_category_my,
            label = R.string.categoryMy
        ),
        MeditationCategory(
            icon = R.drawable.ic_category_anxiety,
            label = R.string.categoryAnxious
        ),
        MeditationCategory(
            icon = R.drawable.ic_category_sleep,
            label = R.string.categorySleep
        ),
        MeditationCategory(
            icon = R.drawable.ic_category_kids,
            label = R.string.categoryKids
        ),
    )
}

data class MeditationCategory(
    @DrawableRes val icon: Int,
    @StringRes val label: Int
)