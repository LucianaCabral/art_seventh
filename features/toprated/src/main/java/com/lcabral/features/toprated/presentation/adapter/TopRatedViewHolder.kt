package com.lcabral.features.toprated.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcabral.features.toprated.databinding.ItemTopRatedBinding
import com.lcabral.features.toprated.domain.model.TopRated

internal class TopRatedViewHolder(private val binding: ItemTopRatedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(topRated: TopRated) {
        setupTopRated(topRated = topRated)
    }

    private fun setupTopRated(topRated: TopRated) {
        itemView.apply {
            with(binding) {
                topRatedMovieTv.text = topRated.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${topRated.posterPath}")
                    .into(topRatedImage)
            }
        }
    }
}
