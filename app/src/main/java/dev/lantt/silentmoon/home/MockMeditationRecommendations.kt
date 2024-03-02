package dev.lantt.silentmoon.home

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockMeditationRecommendations {
    val recommendations = listOf(
        MeditationRecommendation(
            title = R.string.meditationRecommendationFocus,
            description = R.string.meditationRecommendationDescription,
            image = R.drawable.img_focus_recommendation,
            backgroundColor = R.color.meditationRecommendationFocusBgColor
        ),
        MeditationRecommendation(
            title = R.string.meditationRecommendationHappiness,
            description = R.string.meditationRecommendationDescription,
            image = R.drawable.img_happiness_recommendation,
            backgroundColor = R.color.meditationRecommendationHappinessBgColor
        ),
        MeditationRecommendation(
            title = R.string.meditationRecommendationFocus,
            description = R.string.meditationRecommendationDescription,
            image = R.drawable.img_focus_recommendation,
            backgroundColor = R.color.meditationRecommendationFocusBgColor
        ),
        MeditationRecommendation(
            title = R.string.meditationRecommendationHappiness,
            description = R.string.meditationRecommendationDescription,
            image = R.drawable.img_happiness_recommendation,
            backgroundColor = R.color.meditationRecommendationHappinessBgColor
        ),
    )
}

data class MeditationRecommendation(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    @ColorRes val backgroundColor: Int
)