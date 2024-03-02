package dev.lantt.silentmoon.meditate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentMeditateBinding
import dev.lantt.silentmoon.utils.setTopPaddingInset

class MeditateFragment : Fragment() {

    // TODO change
    private var _binding: FragmentMeditateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMeditateBinding.inflate(inflater, container, false)

        binding.meditateTitle.setTopPaddingInset()

        val meditationCategoryAdapter = MeditationCategoryAdapter(
            context = requireContext(),
            categories = MockMeditationCategories.categories
        )
        val categoriesRV = binding.categories
        categoriesRV.adapter = meditationCategoryAdapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeditateFragment()
    }
}