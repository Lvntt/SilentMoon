package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentHomeBinding
import dev.lantt.silentmoon.presentation.adapters.MeditationRecommendationAdapter
import dev.lantt.silentmoon.presentation.data.MockMeditationRecommendations

class HomeFragment : Fragment() {

    // TODO change
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val meditationRecommendationAdapter = MeditationRecommendationAdapter(
            context = requireContext(),
            meditationRecommendations = MockMeditationRecommendations.recommendations
        )

        val meditationRecommendationsRV = binding.recommendations
        meditationRecommendationsRV.adapter = meditationRecommendationAdapter

        return binding.root
    }

}