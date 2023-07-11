package com.lcabral.features.movies.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcabral.features.movies.databinding.ItemMovieBinding
import com.lcabral.features.movies.domain.model.Movie

internal class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(movie: Movie) {
        setupMovie(movie)
    }

    private fun setupMovie(movie: Movie) {
        itemView.apply {
            with(binding) {
                movieTv.text = movie.name
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${movie.posterPath}").into(movieImage)
            }
        }
    }
}
