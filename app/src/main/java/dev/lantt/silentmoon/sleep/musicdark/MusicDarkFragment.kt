package dev.lantt.silentmoon.sleep.musicdark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.FragmentMusicDarkBinding

private const val MUSIC_NAME = "music_name"

class MusicDarkFragment : Fragment() {

    private var _binding: FragmentMusicDarkBinding? = null
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

        _binding = FragmentMusicDarkBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(musicName: String) =
            MusicDarkFragment().apply {
                arguments = Bundle().apply {
                    putString(MUSIC_NAME, musicName)
                }
            }
    }
}