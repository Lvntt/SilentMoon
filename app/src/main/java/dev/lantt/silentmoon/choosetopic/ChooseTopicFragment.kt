package dev.lantt.silentmoon.choosetopic

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentChooseTopicBinding
import dev.lantt.silentmoon.reminders.RemindersFragment
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class ChooseTopicFragment : Fragment() {

    private var _binding: FragmentChooseTopicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChooseTopicBinding.inflate(layoutInflater, container, false)

        binding.titleText.setTopPaddingInset()

        val spannableString = SpannableString(resources.getString(R.string.chooseTopicTitle))
        val boldString = resources.getString(R.string.chooseTopicTitleBoldPart)
        val start = 0
        val end = start + boldString.length

        spannableString.setSpan(
            TextAppearanceSpan(context, R.style.chooseTopicBoldTitleText),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.titleText.text = spannableString

        val meditationTopicAdapter = MeditationTopicAdapter(
            context = requireContext(),
            meditationTopics = MockMeditationTopics.topics,
            onTopicClick = {
                parentFragmentManager.navigateToFragment(RemindersFragment.newInstance())
            }
        )

        val meditationTopicsRV = binding.meditationTopics
        meditationTopicsRV.adapter = meditationTopicAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChooseTopicFragment()
    }

}