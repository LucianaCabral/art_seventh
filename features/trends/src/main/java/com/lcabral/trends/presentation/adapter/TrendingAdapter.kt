package com.lcabral.trends.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.trends.databinding.ItemTrendingCarouselBinding
import com.lcabral.trends.domain.model.Trending

internal class TrendingAdapter : ListAdapter<Trending, TrendingViewHolder>(TrendingDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val binding = ItemTrendingCarouselBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingViewHolder(binding = binding)
    }

    override fun getItemCount() =currentList.size

    override fun getItem(position: Int): Trending {
        return currentList[position]
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        return holder.bindView(currentList[position])
    }
}