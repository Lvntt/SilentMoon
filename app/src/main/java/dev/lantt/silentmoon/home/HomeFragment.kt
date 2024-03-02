package dev.lantt.silentmoon.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentHomeBinding
import dev.lantt.silentmoon.coursedetails.CourseDetailsFragment
import dev.lantt.silentmoon.utils.NavigationManager
import dev.lantt.silentmoon.utils.UserManager
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class HomeFragment : Fragment() {

    // TODO change
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val userManager by lazy {
        requireActivity() as UserManager
    }
    private val navigationManager by lazy {
        requireActivity() as NavigationManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val username = userManager.getUsername()
        navigationManager.showBottomNavigationBar()

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

        val meditationRecommendationAdapter = MeditationRecommendationAdapter(
            context = requireContext(),
            meditationRecommendations = MockMeditationRecommendations.recommendations,
            onRecommendationClick = {
                navigateToCourseDetails()
            }
        )

        binding.homeTitle.text = getString(R.string.homeTitle, username)

        val meditationRecommendationsRV = binding.recommendations
        meditationRecommendationsRV.adapter = meditationRecommendationAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToCourseDetails() {
        parentFragmentManager.navigateToFragment(CourseDetailsFragment.newInstance())
        navigationManager.hideBottomNavigationBar()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }

}