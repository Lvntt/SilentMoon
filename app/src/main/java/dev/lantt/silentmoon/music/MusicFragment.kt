package dev.lantt.silentmoon.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentMusicBinding

private const val MUSIC_NAME = "music_name"

class MusicFragment : Fragment() {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    private var musicName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            musicName = it.getString(MUSIC_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMusicBinding.inflate(inflater, container, false)

        binding.musicName.text = musicName

        binding.closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(musicName: String) =
            MusicFragment().apply {
                arguments = Bundle().apply {
                    putString(MUSIC_NAME, musicName)
                }
            }
    }
}