package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentCourseDetailsBinding
import dev.lantt.silentmoon.presentation.adapters.CourseDetailsPageAdapter

class CourseDetailsFragment : Fragment() {
    // TODO change
    private var _binding: FragmentCourseDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseDetailsBinding.inflate(layoutInflater, container, false)

        val courseDetailsPageAdapter = CourseDetailsPageAdapter(parentFragmentManager, lifecycle)
        val tabLayout = binding.tabs

        binding.viewPager.adapter = courseDetailsPageAdapter

        tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab != null) {
                        binding.viewPager.currentItem = tab.position
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}

            }
        )

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.likeButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                getString(R.string.courseSaveToFavourites),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.downloadButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                getString(R.string.courseDownload),
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CourseDetailsFragment()
    }
}