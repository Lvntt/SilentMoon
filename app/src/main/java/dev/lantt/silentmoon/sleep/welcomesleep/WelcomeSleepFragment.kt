package dev.lantt.silentmoon.sleep.welcomesleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentWelcomeSleepBinding

class WelcomeSleepFragment : Fragment() {

    private var _binding: FragmentWelcomeSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeSleepBinding.inflate(inflater, container, false)

        binding.getStartedButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeSleepFragment()
    }
}