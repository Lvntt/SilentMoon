package dev.lantt.silentmoon.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemMeditationRecommendationBinding
import dev.lantt.silentmoon.presentation.data.MeditationRecommendation

class MeditationRecommendationAdapter(
    private val context: Context,
    private val meditationRecommendations: List<MeditationRecommendation>,
    private val onRecommendationClick: () -> Unit,
) : RecyclerView.Adapter<MeditationRecommendationAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMeditationRecommendationBinding.bind(view)

        init {
            binding.meditationRecommendation.setOnClickListener {
                onRecommendationClick()
            }
        }

        fun bind(recommendation: MeditationRecommendation) = with (binding) {
            recommendationImage.setImageDrawable(ContextCompat.getDrawable(context, recommendation.image))
            recommendationImage.backgroundTintList = ContextCompat.getColorStateList(context, recommendation.backgroundColor)
            recommendationTitle.text = context.resources.getString(recommendation.title)
            recommendationDescription.text = context.resources.getString(recommendation.description)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MeditationRecommendationAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_meditation_recommendation, parent, false)
        )
    }

    override fun getItemCount(): Int = meditationRecommendations.size

    override fun onBindViewHolder(holder: MeditationRecommendationAdapter.ViewHolder, position: Int) {
        holder.bind(meditationRecommendations[position])
    }

}