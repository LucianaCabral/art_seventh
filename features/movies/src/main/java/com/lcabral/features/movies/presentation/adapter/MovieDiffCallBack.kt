package com.lcabral.features.movies.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lcabral.features.movies.domain.model.Movie

internal class MovieDiffCallBack : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.
        posterPath == newItem.posterPath
    }
}
