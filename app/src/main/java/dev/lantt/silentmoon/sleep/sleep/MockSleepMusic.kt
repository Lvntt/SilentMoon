package dev.lantt.silentmoon.sleep.sleep

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockSleepMusic {
    val sleepMusic = listOf(
        SleepMusic(
            image = R.drawable.img_night_island,
            title = R.string.storyNightIsland
        ),
        SleepMusic(
            image = R.drawable.img_sweet_sleep,
            title = R.string.storySweetSleep
        ),
        SleepMusic(
            image = R.drawable.img_good_night,
            title = R.string.storyGoodNight
        ),
        SleepMusic(
            image = R.drawable.img_moon_clouds,
            title = R.string.storyMoonClouds
        ),
        SleepMusic(
            image = R.drawable.img_night_island,
            title = R.string.storyNightIsland
        ),
        SleepMusic(
            image = R.drawable.img_sweet_sleep,
            title = R.string.storySweetSleep
        ),
        SleepMusic(
            image = R.drawable.img_good_night,
            title = R.string.storyGoodNight
        ),
        SleepMusic(
            image = R.drawable.img_moon_clouds,
            title = R.string.storyMoonClouds
        ),
    )
}

data class SleepMusic(
    @DrawableRes val image: Int,
    @StringRes val title: Int
)