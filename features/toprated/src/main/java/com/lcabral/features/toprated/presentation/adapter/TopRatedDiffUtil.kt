package com.lcabral.features.toprated.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lcabral.features.toprated.domain.model.TopRated

internal class TopRatedDiffUtil  : DiffUtil.ItemCallback<TopRated>() {
    override fun areItemsTheSame(oldItem: TopRated, newItem: TopRated): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TopRated, newItem: TopRated): Boolean {
        return  oldItem.id == newItem.id && oldItem.title ==  newItem.title &&
                oldItem.posterPath == newItem.posterPath
    }
}
