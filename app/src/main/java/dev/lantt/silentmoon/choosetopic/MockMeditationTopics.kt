package dev.lantt.silentmoon.choosetopic

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockMeditationTopics {
    val topics = listOf(
        MeditationTopic(
            title = R.string.topicReduceStress,
            image = R.drawable.img_reduce_stress,
            backgroundColor = R.color.topicReduceStressBgColor,
            textColor = R.color.topicReduceStressTextColor,
            isLong = true,
            hasTopPadding = false
        ),
        MeditationTopic(
            title = R.string.topicImprovePerformance,
            image = R.drawable.img_improve_performance,
            backgroundColor = R.color.topicImprovePerformanceBgColor,
            textColor = R.color.topicImprovePerformanceTextColor,
            isLong = false,
            hasTopPadding = true
        ),
        MeditationTopic(
            title = R.string.topicReduceAnxiety,
            image = R.drawable.img_reduce_anxiety,
            backgroundColor = R.color.topicReduceAnxietyBgColor,
            textColor = R.color.topicReduceAnxietyTextColor,
            isLong = true,
            hasTopPadding = true
        ),
        MeditationTopic(
            title = R.string.topicIncreaseHappiness,
            image = R.drawable.img_increase_happiness,
            backgroundColor = R.color.topicIncreaseHappinessBgColor,
            textColor = R.color.topicIncreaseHappinessTextColor,
            isLong = false,
            hasTopPadding = false
        ),
        MeditationTopic(
            title = R.string.topicPersonalGrowth,
            image = R.drawable.img_personal_growth,
            backgroundColor = R.color.topicPersonalGrowthBgColor,
            textColor = R.color.topicPersonalGrowthTextColor,
            isLong = true,
            hasTopPadding = true
        ),
        MeditationTopic(
            title = R.string.topicBetterSleep,
            image = R.drawable.img_better_sleep,
            backgroundColor = R.color.topicBetterSleepBgColor,
            textColor = R.color.topicBetterSleepTextColor,
            isLong = false,
            hasTopPadding = true
        ),
        MeditationTopic(
            title = R.string.topicIncreaseProductivity,
            image = R.drawable.img_increase_productivity,
            backgroundColor = R.color.topicIncreaseProductivityBgColor,
            textColor = R.color.topicIncreaseProductivityTextColor,
            isLong = true,
            hasTopPadding = true
        ),
        MeditationTopic(
            title = R.string.topicManageTime,
            image = R.drawable.img_manage_time,
            backgroundColor = R.color.topicManageTimeBgColor,
            textColor = R.color.topicManageTimeTextColor,
            isLong = true,
            hasTopPadding = false
        ),
    )
}

data class MeditationTopic(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val textColor: Int,
    val isLong: Boolean,
    val hasTopPadding: Boolean
)