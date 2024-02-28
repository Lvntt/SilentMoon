package dev.lantt.silentmoon.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemMeditationTopicBinding
import dev.lantt.silentmoon.presentation.data.MeditationTopic

class MeditationTopicAdapter(
    private val context: Context,
    private val meditationTopics: List<MeditationTopic>,
    private val onTopicClick: () -> Unit,
) : RecyclerView.Adapter<MeditationTopicAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMeditationTopicBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                onTopicClick()
            }
        }

        fun bind(topic: MeditationTopic) = with (binding) {
            val topicLayoutParams = topicLayout.layoutParams as FrameLayout.LayoutParams
            val bgImageLayoutParams = topicImage.layoutParams as FrameLayout.LayoutParams

            if (topic.isLong) {
                topicLayoutParams.height = context.resources.getDimensionPixelSize(R.dimen.long_topic_height)
            }
            if (topic.hasTopPadding) {
                bgImageLayoutParams.topMargin = context.resources.getDimensionPixelSize(R.dimen.topic_top_margin)
            }

            topicLayout.layoutParams = topicLayoutParams

            topicLayout.backgroundTintList = ContextCompat.getColorStateList(context, topic.backgroundColor)
            topicImage.setImageDrawable(ContextCompat.getDrawable(context, topic.image))
            topicTitle.text = context.resources.getString(topic.title)
            topicTitle.setTextColor(ContextCompat.getColor(context, topic.textColor))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_meditation_topic, parent, false)
        )
    }

    override fun getItemCount(): Int = meditationTopics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(meditationTopics[position])
    }

}