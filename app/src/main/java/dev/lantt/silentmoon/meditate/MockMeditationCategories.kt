package dev.lantt.silentmoon.meditate

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockMeditationCategories {
    val categories = listOf(
        MeditationCategory(
            selectedImage = R.drawable.ic_category_all_selected,
            unselectedImage = R.drawable.ic_category_all,
            label = R.string.categoryAll
        ),
        MeditationCategory(
            selectedImage = R.drawable.ic_category_my_selected,
            unselectedImage = R.drawable.ic_category_my,
            label = R.string.categoryMy
        ),
        MeditationCategory(
            selectedImage = R.drawable.ic_category_anxiety_selected,
            unselectedImage = R.drawable.ic_category_anxiety,
            label = R.string.categoryAnxious
        ),
        MeditationCategory(
            selectedImage = R.drawable.ic_category_sleep_selected,
            unselectedImage = R.drawable.ic_category_sleep,
            label = R.string.categorySleep
        ),
        MeditationCategory(
            selectedImage = R.drawable.ic_category_kids_selected,
            unselectedImage = R.drawable.ic_category_kids,
            label = R.string.categoryKids
        ),
    )
}

data class MeditationCategory(
    @DrawableRes val selectedImage: Int,
    @DrawableRes val unselectedImage: Int,
    @StringRes val label: Int
)