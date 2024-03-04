package dev.lantt.silentmoon.sleep.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSleepBinding
import dev.lantt.silentmoon.meditate.MeditationCategoryAdapter
import dev.lantt.silentmoon.meditate.MockMeditationCategories
import dev.lantt.silentmoon.utils.HorizontalSpaceItemDecoration

class SleepFragment : Fragment() {

    private var _binding: FragmentSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSleepBinding.inflate(inflater, container, false)

        val context = requireContext()

        val categoriesHorizontalPadding = context.resources.getDimensionPixelSize(R.dimen.categories_horizontal_padding)
        val horizontalSpaceItemDecoration = HorizontalSpaceItemDecoration(categoriesHorizontalPadding)
        val meditationCategoryAdapter = MeditationCategoryAdapter(
            context = context,
            categories = MockMeditationCategories.categories,
            isSleepMode = true
        )
        val categoriesRV = binding.categories
        categoriesRV.adapter = meditationCategoryAdapter
        categoriesRV.addItemDecoration(horizontalSpaceItemDecoration)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SleepFragment()
    }
}