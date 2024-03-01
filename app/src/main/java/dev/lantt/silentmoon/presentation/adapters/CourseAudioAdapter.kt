package dev.lantt.silentmoon.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemCourseAudioBinding
import dev.lantt.silentmoon.presentation.data.CourseAudio

class CourseAudioAdapter(
    private val context: Context,
    private val courseAudio: List<CourseAudio>,
) : RecyclerView.Adapter<CourseAudioAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCourseAudioBinding.bind(view)

        fun bind(audio: CourseAudio) = with(binding) {
            if (audio.isAccent) {
                playAudioButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_button_accent))
            } else {
                playAudioButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_button_regular))
            }

            courseAudioTitle.text = context.resources.getString(audio.title)
            courseAudioDuration.text = context.resources.getString(audio.duration)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_course_audio, parent, false)
        )
    }

    override fun getItemCount(): Int = courseAudio.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(courseAudio[position])
    }

}