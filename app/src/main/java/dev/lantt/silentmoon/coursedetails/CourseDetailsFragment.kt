package dev.lantt.silentmoon.coursedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentCourseDetailsBinding

class CourseDetailsFragment : Fragment() {

    private var _binding: FragmentCourseDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseDetailsBinding.inflate(layoutInflater, container, false)

        val context = requireContext()
        val courseDetailsPageAdapter = CourseDetailsPageAdapter(parentFragmentManager, lifecycle)

        binding.viewPager.adapter = courseDetailsPageAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = context.getString(R.string.maleVoice)
                }
                else -> {
                    tab.text = context.getString(R.string.femaleVoice)
                }
            }
        }.attach()

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CourseDetailsFragment()
    }
}