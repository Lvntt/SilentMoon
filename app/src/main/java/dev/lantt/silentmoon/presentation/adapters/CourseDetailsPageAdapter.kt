package dev.lantt.silentmoon.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.lantt.silentmoon.presentation.data.NarratorType
import dev.lantt.silentmoon.presentation.fragments.CourseAudioFragment

class CourseDetailsPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            CourseAudioFragment.newInstance(NarratorType.MALE_VOICE)
        } else {
            CourseAudioFragment.newInstance(NarratorType.FEMALE_VOICE)
        }
    }

    private companion object {
        const val PAGE_COUNT = 2
    }

}