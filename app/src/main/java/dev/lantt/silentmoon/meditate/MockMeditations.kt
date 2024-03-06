package dev.lantt.silentmoon.meditate

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockMeditations {
    val meditations = listOf(
        Meditation(
            title = R.string.sevenDaysOfCalm,
            image = R.drawable.img_7_days_of_calm_bg_blur,
            isLong = true
        ),
        Meditation(
            title = R.string.anxietyRelease,
            image = R.drawable.img_anxiety_release_bg_blur,
            isLong = false
        ),
        Meditation(
            title = R.string.howToMeditate,
            image = R.drawable.img_how_to_meditate_bg_blur2,
            isLong = true
        ),
        Meditation(
            title = R.string.howToMeditate,
            image = R.drawable.img_how_to_meditate_bg_blur,
            isLong = false
        ),
    )
}

data class Meditation(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    val isLong: Boolean
)