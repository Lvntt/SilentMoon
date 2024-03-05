package dev.lantt.silentmoon.meditate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.coursedetails.CourseDetailsFragment
import dev.lantt.silentmoon.databinding.FragmentMeditateBinding
import dev.lantt.silentmoon.utils.HorizontalSpaceItemDecoration
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class MeditateFragment : Fragment() {

    private var _binding: FragmentMeditateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMeditateBinding.inflate(inflater, container, false)
        val context = requireContext()

        binding.meditateTitle.setTopPaddingInset()

        binding.dailyCalmCardLayout.setOnClickListener {
            parentFragmentManager.navigateToFragment(CourseDetailsFragment.newInstance())
        }

        val categoriesHorizontalPadding = context.resources.getDimensionPixelSize(R.dimen.categories_horizontal_padding)
        val horizontalSpaceItemDecoration = HorizontalSpaceItemDecoration(categoriesHorizontalPadding)

        val meditationCategoryAdapter = MeditationCategoryAdapter(
            context = context,
            categories = MockMeditationCategories.categories,
            isSleepMode = false
        )
        val categoriesRV = binding.categories
        categoriesRV.adapter = meditationCategoryAdapter
        categoriesRV.addItemDecoration(horizontalSpaceItemDecoration)

        val meditationsAdapter = MeditationsAdapter(
            context = context,
            meditations = MockMeditations.meditations
        )
        val meditationsRV = binding.meditations
        meditationsRV.adapter = meditationsAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeditateFragment()
    }
}