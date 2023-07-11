package com.lcabral.features.movies.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.features.movies.databinding.ItemMovieBinding
import com.lcabral.features.movies.domain.model.Movie

internal class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffCallBack()) {

    private val movieList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Movie {
        return movieList[position]
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position).let(holder::bindView)
    }
}
