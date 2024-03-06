package dev.lantt.silentmoon.sleep.sleepmusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentSleepMusicBinding
import dev.lantt.silentmoon.sleep.playoption.PlayOptionFragment
import dev.lantt.silentmoon.sleep.sleep.MockSleepMusic
import dev.lantt.silentmoon.sleep.sleep.SleepMusicAdapter
import dev.lantt.silentmoon.utils.navigateToFragment

class SleepMusicFragment : Fragment() {

    private var _binding: FragmentSleepMusicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSleepMusicBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val context = requireContext()

        val sleepMusicRV = binding.sleepMusicList
        sleepMusicRV.adapter = SleepMusicAdapter(
            context = context,
            sleepMusicList = MockSleepMusic.sleepMusic,
            onSleepMusicClick = {
                parentFragment?.parentFragmentManager?.navigateToFragment(PlayOptionFragment.newInstance())
            }
        )

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SleepMusicFragment()
    }
}