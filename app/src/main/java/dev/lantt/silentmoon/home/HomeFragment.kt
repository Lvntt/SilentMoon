package dev.lantt.silentmoon.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentHomeBinding
import dev.lantt.silentmoon.coursedetails.CourseDetailsFragment
import dev.lantt.silentmoon.utils.HorizontalSpaceItemDecoration
import dev.lantt.silentmoon.utils.UserManager
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val userManager by lazy {
        requireActivity() as UserManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val context = requireContext()
        val username = userManager.getUsername()

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.appTitle.setTopPaddingInset()
        binding.basicsCourseCardLayout.setOnClickListener {
            navigateToCourseDetails()
        }
        binding.relaxationMusicCardLayout.setOnClickListener {
            navigateToCourseDetails()
        }
        binding.dailyThoughtCardLayout.setOnClickListener {
            navigateToCourseDetails()
        }
        binding.basicsCourseStartButton.setOnClickListener {
            navigateToCourseDetails()
        }
        binding.relaxationMusicStartButton.setOnClickListener {
            navigateToCourseDetails()
        }

        val recommendationsHorizontalPadding = context.resources.getDimensionPixelSize(R.dimen.recommendations_horizontal_padding)
        val horizontalSpaceItemDecoration = HorizontalSpaceItemDecoration(recommendationsHorizontalPadding)
        val meditationRecommendationAdapter = MeditationRecommendationAdapter(
            context = context,
            meditationRecommendations = MockMeditationRecommendations.recommendations,
            onRecommendationClick = {
                navigateToCourseDetails()
            }
        )

        binding.homeTitle.text = getString(R.string.homeTitle, username)

        val meditationRecommendationsRV = binding.recommendations
        meditationRecommendationsRV.adapter = meditationRecommendationAdapter
        meditationRecommendationsRV.addItemDecoration(horizontalSpaceItemDecoration)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToCourseDetails() {
        parentFragment?.parentFragmentManager?.navigateToFragment(CourseDetailsFragment.newInstance())
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }

}