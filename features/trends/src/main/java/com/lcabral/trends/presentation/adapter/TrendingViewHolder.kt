package com.lcabral.trends.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcabral.trends.databinding.ItemTrendingCarouselBinding
import com.lcabral.trends.domain.model.Trending

internal class TrendingViewHolder(private val binding: ItemTrendingCarouselBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(trending: Trending) {
        setupTrending(trending = trending)
    }

    fun setupTrending(trending: Trending) {
        with(binding) {
            trendingMovieTv.text = trending.title.toString()
            Glide.with(trendingImage).apply { trending.backdropPath }
        }
    }
}