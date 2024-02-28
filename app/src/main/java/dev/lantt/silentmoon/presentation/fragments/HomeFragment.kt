package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentHomeBinding
import dev.lantt.silentmoon.presentation.adapters.MeditationRecommendationAdapter
import dev.lantt.silentmoon.presentation.data.MockMeditationRecommendations
import dev.lantt.silentmoon.utils.NavigationManager
import dev.lantt.silentmoon.utils.UserManager

class HomeFragment : Fragment() {

    // TODO change
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigationManager = requireActivity() as NavigationManager
        navigationManager.showBottomNavigationBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val userManager = requireActivity() as UserManager
        val username = userManager.getUsername()

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val meditationRecommendationAdapter = MeditationRecommendationAdapter(
            context = requireContext(),
            meditationRecommendations = MockMeditationRecommendations.recommendations
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

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }

}