package dev.lantt.silentmoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentBottomNavigationHostBinding
import dev.lantt.silentmoon.home.HomeFragment
import dev.lantt.silentmoon.meditate.MeditateFragment
import dev.lantt.silentmoon.music.MusicFragment
import dev.lantt.silentmoon.signinsignup.SignInSignUpFragment
import dev.lantt.silentmoon.sleep.sleep.SleepFragment
import dev.lantt.silentmoon.sleep.welcomesleep.WelcomeSleepFragment
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.navigateToFragmentWithBottomBar

class BottomNavigationHostFragment : Fragment() {

    private var _binding: FragmentBottomNavigationHostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomNavigationHostBinding.inflate(inflater, container, false)

        // TODO work with back button and back stack
        val bottomNavigationBar = binding.bottomNavigationBar
        bottomNavigationBar.setOnItemSelectedListener { item ->
            var newFragment: Fragment = HomeFragment.newInstance()
            var hasBottomBar = true

            when (item.itemId) {
                R.id.bottom_navigation_home -> {
                    hasBottomBar = true
                    newFragment = HomeFragment.newInstance()
                }
                R.id.bottom_navigation_sleep -> {
                    newFragment = WelcomeSleepFragment.newInstance()

                    childFragmentManager.navigateToFragmentWithBottomBar(SleepFragment.newInstance())

                    parentFragmentManager.beginTransaction()
                        .add(R.id.fragmentHost, newFragment)
                        .addToBackStack(null)
                        .commit()

                    setSleepBottomBarTheme()

                    return@setOnItemSelectedListener true
                }
                R.id.bottom_navigation_meditate -> {
                    hasBottomBar = true
                    newFragment = MeditateFragment.newInstance()
                }
                R.id.bottom_navigation_music -> {
                    hasBottomBar = false
                    newFragment = MusicFragment.newInstance(getString(R.string.focusAttention))
                }
                R.id.bottom_navigation_profile -> {
                    hasBottomBar = true
                    newFragment = SignInSignUpFragment.newInstance()
                }
            }

            if (hasBottomBar) {
                childFragmentManager.navigateToFragmentWithBottomBar(newFragment)
            } else {
                parentFragmentManager.navigateToFragment(newFragment)
            }

            setDefaultBottomBarTheme()

            return@setOnItemSelectedListener true
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            childFragmentManager.popBackStack()
        }
    }

    private fun setSleepBottomBarTheme() {
        val context = requireContext()

        binding.bottomNavigationBar.background = ContextCompat.getDrawable(context, R.color.sleepBackgroundColor)
        binding.bottomNavigationBar.itemIconTintList = ContextCompat.getColorStateList(context, R.color.bottom_nav_sleep_icon_selector)
        binding.bottomNavigationBar.itemTextColor = ContextCompat.getColorStateList(context, R.color.bottom_nav_sleep_label_selector)
    }

    private fun setDefaultBottomBarTheme() {
        val context = requireContext()

        binding.bottomNavigationBar.background = ContextCompat.getDrawable(context, R.color.white)
        binding.bottomNavigationBar.itemIconTintList = ContextCompat.getColorStateList(context, R.color.bottom_nav_icon_selector)
        binding.bottomNavigationBar.itemTextColor = ContextCompat.getColorStateList(context, R.color.bottom_nav_label_selector)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BottomNavigationHostFragment()
    }
}