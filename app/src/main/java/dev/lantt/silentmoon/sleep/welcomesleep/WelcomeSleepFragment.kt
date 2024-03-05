package dev.lantt.silentmoon.sleep.welcomesleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentWelcomeSleepBinding
import dev.lantt.silentmoon.sleep.sleep.SleepFragment
import dev.lantt.silentmoon.utils.NavigationManager
import dev.lantt.silentmoon.utils.navigateToFragment

class WelcomeSleepFragment : Fragment() {

    private var _binding: FragmentWelcomeSleepBinding? = null
    private val binding get() = _binding!!

    private val navigationManager by lazy {
        requireActivity() as NavigationManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeSleepBinding.inflate(inflater, container, false)

        binding.getStartedButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(SleepFragment.newInstance())
            navigationManager.showBottomNavigationBar()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeSleepFragment()
    }
}