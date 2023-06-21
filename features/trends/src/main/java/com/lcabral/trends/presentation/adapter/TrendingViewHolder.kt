package com.lcabral.trends.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.lcabral.trends.R
import com.lcabral.trends.databinding.ItemTrendingCarouselBinding
import com.lcabral.trends.domain.model.Trending

internal class TrendingViewHolder(private val binding: ItemTrendingCarouselBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(trending: Trending) {
        setupTrending(trending = trending)
    }

    fun setupTrending(trending: Trending) {
        itemView.apply {
            with(binding) {
                trendingMovieTv.text = trending.title
                Glide.with(root.context).load(trending.posterPath).into(trendingImage)
                trendingImage.load(trending.posterPath) {
                    placeholder(R.drawable.ic_movie)
                    fallback(R.drawable.ic_movie)
                }
            }
        }
    }
}