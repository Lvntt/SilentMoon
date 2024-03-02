package dev.lantt.silentmoon.meditate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.ItemMeditationCategoryBinding

class MeditationCategoryAdapter(
    private val context: Context,
    private val categories: List<MeditationCategory>,
) : RecyclerView.Adapter<MeditationCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMeditationCategoryBinding.bind(view)

        fun bind(category: MeditationCategory, isInitiallySelected: Boolean) = with (binding) {
            if (isInitiallySelected) {
                categoryButton.isChecked = true
                categoryLabel.text = ContextCompat.getString(context, category.label)
                categoryButton.background = ContextCompat.getDrawable(context, category.selectedImage)
                categoryLabel.setTextColor(ContextCompat.getColor(context, R.color.selectedCategoryTextColor))
            } else {
                categoryLabel.text = ContextCompat.getString(context, category.label)
                categoryButton.background = ContextCompat.getDrawable(context, category.unselectedImage)
                categoryLabel.setTextColor(ContextCompat.getColor(context, R.color.unselectedCategoryTextColor))
            }

            binding.categoryButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    categoryButton.setBackgroundDrawable(ContextCompat.getDrawable(context, category.selectedImage))
                    categoryLabel.setTextColor(ContextCompat.getColor(context, R.color.selectedCategoryTextColor))
                } else {
                    categoryButton.setBackgroundDrawable(ContextCompat.getDrawable(context, category.unselectedImage))
                    categoryLabel.setTextColor(ContextCompat.getColor(context, R.color.unselectedCategoryTextColor))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_meditation_category, parent, false)
        )
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position], position == 0)
    }

}