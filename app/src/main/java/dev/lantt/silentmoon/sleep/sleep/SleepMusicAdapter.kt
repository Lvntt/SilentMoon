package dev.lantt.silentmoon.sleep.sleep

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemSleepMusicBinding

class SleepMusicAdapter(
    private val context: Context,
    private val sleepMusicList: List<SleepMusic>,
    private val onSleepMusicClick: () -> Unit,
) : RecyclerView.Adapter<SleepMusicAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSleepMusicBinding.bind(view)

        init {
            binding.sleepMusic.setOnClickListener {
                onSleepMusicClick()
            }
        }

        fun bind(sleepMusic: SleepMusic) = with (binding) {
            sleepMusicImage.setImageDrawable(ContextCompat.getDrawable(context, sleepMusic.image))
            sleepMusicTitle.text = ContextCompat.getString(context, sleepMusic.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_sleep_music, parent, false)
        )
    }

    override fun getItemCount(): Int = sleepMusicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sleepMusicList[position])
    }

}