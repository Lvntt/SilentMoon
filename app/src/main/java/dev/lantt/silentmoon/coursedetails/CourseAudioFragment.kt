package dev.lantt.silentmoon.coursedetails

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lantt.silentmoon.databinding.FragmentCourseAudioBinding
import dev.lantt.silentmoon.music.MusicFragment
import dev.lantt.silentmoon.utils.navigateToFragment

private const val NARRATOR_TYPE = "narrator_type"

class CourseAudioFragment : Fragment() {

    private var _binding: FragmentCourseAudioBinding? = null
    private val binding get() = _binding!!

    private var narratorType: NarratorType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            narratorType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(NARRATOR_TYPE, NarratorType::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.getSerializable(NARRATOR_TYPE) as NarratorType
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseAudioBinding.inflate(layoutInflater, container, false)

        val courseAudioRV = binding.courseAudio
        val courseAudioAdapter = CourseAudioAdapter(
            context = requireContext(),
            courseAudio = if (narratorType == NarratorType.MALE_VOICE)
                MockCourseAudio.maleVoiceAudio else
                MockCourseAudio.femaleVoiceAudio,
            onCourseAudioClick = {
                parentFragment?.parentFragmentManager?.navigateToFragment(MusicFragment.newInstance(getString(it.title)))
            }
        )
        val dividerItemDecoration =
            DividerItemDecoration(courseAudioRV.context, LinearLayoutManager.VERTICAL)

        courseAudioRV.adapter = courseAudioAdapter
        courseAudioRV.addItemDecoration(dividerItemDecoration)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(narratorType: NarratorType) =
            CourseAudioFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(NARRATOR_TYPE, narratorType)
                }
            }
    }
}