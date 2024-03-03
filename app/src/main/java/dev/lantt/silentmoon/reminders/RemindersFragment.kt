package dev.lantt.silentmoon.reminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentRemindersBinding
import dev.lantt.silentmoon.home.HomeFragment
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class RemindersFragment : Fragment() {

    private var _binding: FragmentRemindersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRemindersBinding.inflate(inflater, container, false)

        binding.timeQuestion.setTopPaddingInset()

        binding.saveButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(HomeFragment.newInstance())
        }

        binding.noThanks.setOnClickListener {
            parentFragmentManager.navigateToFragment(HomeFragment.newInstance())
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
            RemindersFragment()
    }

}