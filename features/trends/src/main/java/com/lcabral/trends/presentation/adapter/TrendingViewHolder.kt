package com.lcabral.trends.presentation.adapter

import android.net.Uri
import androidx.core.net.toUri
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
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${trending.posterPath}").into(trendingImage)
            }
        }
    }
}