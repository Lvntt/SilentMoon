package dev.lantt.silentmoon.presentation.data

import androidx.annotation.StringRes
import dev.lantt.silentmoon.R

object MockCourseAudio {
    val maleVoiceAudio = listOf(
        CourseAudio(
            isAccent = true,
            title = R.string.focusAttention,
            duration = R.string.duration_10_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.bodyScan,
            duration = R.string.duration_5_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.makingHappiness,
            duration = R.string.duration_3_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.focusAttention,
            duration = R.string.duration_10_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.bodyScan,
            duration = R.string.duration_5_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.makingHappiness,
            duration = R.string.duration_3_minutes
        ),
    )

    val femaleVoiceAudio = listOf(
        CourseAudio(
            isAccent = true,
            title = R.string.makingHappiness,
            duration = R.string.duration_3_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.bodyScan,
            duration = R.string.duration_5_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.focusAttention,
            duration = R.string.duration_10_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.makingHappiness,
            duration = R.string.duration_3_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.bodyScan,
            duration = R.string.duration_5_minutes
        ),
        CourseAudio(
            isAccent = false,
            title = R.string.focusAttention,
            duration = R.string.duration_10_minutes
        ),
    )
}

data class CourseAudio(
    val isAccent: Boolean,
    @StringRes val title: Int,
    @StringRes val duration: Int
)