package dev.lantt.silentmoon.meditate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemMeditationBinding

class MeditationsAdapter(
    private val context: Context,
    private val meditations: List<Meditation>,
) : RecyclerView.Adapter<MeditationsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMeditationBinding.bind(view)

        fun bind(meditation: Meditation) = with (binding) {
            val meditationLayoutParams = meditationLayout.layoutParams as FrameLayout.LayoutParams

            if (meditation.isLong) {
                meditationLayoutParams.height = context.resources.getDimensionPixelSize(R.dimen.long_meditation_height)
            }

            meditationLayout.layoutParams = meditationLayoutParams

            meditationImage.setImageDrawable(ContextCompat.getDrawable(context, meditation.image))
            meditationLabel.text = context.resources.getString(meditation.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_meditation, parent, false)
        )
    }

    override fun getItemCount(): Int = meditations.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(meditations[position])
    }

}