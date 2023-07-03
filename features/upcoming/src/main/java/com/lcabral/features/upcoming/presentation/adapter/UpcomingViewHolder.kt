package com.lcabral.features.upcoming.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcabral.features.upcoming.databinding.ItemUpcomingBinding
import com.lcabral.features.upcoming.domain.model.Upcoming

internal class UpcomingViewHolder(private val binding: ItemUpcomingBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(upcoming: Upcoming) {
        setupUpcoming(upcoming = upcoming)
    }

    private fun setupUpcoming(upcoming: Upcoming) {
        itemView.apply {
            with(binding) {
                upcomingMovieTv.text = upcoming.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${upcoming.posterPath}")
                    .into(upcomingImage)
            }
        }
    }
}
