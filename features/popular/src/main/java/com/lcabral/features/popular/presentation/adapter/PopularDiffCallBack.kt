package com.lcabral.features.popular.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lcabral.features.popular.domain.model.Popular

internal class PopularDiffCallBack : DiffUtil.ItemCallback<Popular>() {
    override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
        return  oldItem.id == newItem.id && oldItem.title ==  newItem.title &&
            oldItem.posterPath == newItem.posterPath
    }
}
