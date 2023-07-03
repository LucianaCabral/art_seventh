package com.lcabral.features.popular.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcabral.features.popular.databinding.ItemPopularBinding
import com.lcabral.features.popular.domain.model.Popular

internal class PopularViewHolder (private val binding: ItemPopularBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bindView(popular: Popular) {
            setupPopular(popular = popular)
        }

    fun setupPopular(popular: Popular) {
        itemView.apply {
            with(binding) {
                popularMovieTv.text = popular.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${popular.posterPath}").into(popularImage)
            }
        }
    }
}
