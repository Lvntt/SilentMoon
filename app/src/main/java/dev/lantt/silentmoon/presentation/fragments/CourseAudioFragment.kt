package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lantt.silentmoon.databinding.FragmentCourseAudioBinding
import dev.lantt.silentmoon.presentation.adapters.CourseAudioAdapter
import dev.lantt.silentmoon.presentation.data.MockCourseAudio
import dev.lantt.silentmoon.presentation.data.NarratorType

private const val NARRATOR_TYPE = "narrator_type"

class CourseAudioFragment : Fragment() {

    // TODO change
    private var _binding: FragmentCourseAudioBinding? = null
    private val binding get() = _binding!!

    private var narratorType: NarratorType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // TODO if API condition
            narratorType = it.getSerializable(NARRATOR_TYPE) as NarratorType
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
                MockCourseAudio.femaleVoiceAudio
        )
        val dividerItemDecoration = DividerItemDecoration(courseAudioRV.context, LinearLayoutManager.VERTICAL)

        courseAudioRV.adapter = courseAudioAdapter
        courseAudioRV.addItemDecoration(dividerItemDecoration)

        return binding.root
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