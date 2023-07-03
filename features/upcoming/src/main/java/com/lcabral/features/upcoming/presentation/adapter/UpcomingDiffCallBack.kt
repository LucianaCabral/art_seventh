package com.lcabral.features.upcoming.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lcabral.features.upcoming.domain.model.Upcoming

internal class UpcomingDiffCallBack : DiffUtil.ItemCallback<Upcoming>() {
    override fun areItemsTheSame(oldItem: Upcoming, newItem: Upcoming): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Upcoming, newItem: Upcoming): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title &&
                oldItem.posterPath == newItem.posterPath
    }
}
