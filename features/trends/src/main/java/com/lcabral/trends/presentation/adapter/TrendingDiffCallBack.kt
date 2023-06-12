package com.lcabral.trends.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lcabral.trends.domain.model.Trending

internal class TrendingDiffCallBack : DiffUtil.ItemCallback<Trending>() {
    override fun areItemsTheSame(oldItem: Trending, newItem: Trending): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Trending, newItem: Trending): Boolean {
        return oldItem == newItem
    }
}