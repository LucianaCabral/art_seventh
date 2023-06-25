package com.lcabral.trends.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.trends.databinding.ItemTrendingCarouselBinding
import com.lcabral.trends.domain.model.Trending

internal class TrendingAdapter : ListAdapter<Trending, TrendingViewHolder>(TrendingDiffCallBack()) {

    private val trendingList = ArrayList<Trending>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val binding = ItemTrendingCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = trendingList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(trendings: List<Trending>) {
        trendingList.clear()
        trendingList.addAll(trendings)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Trending {
        return trendingList[position]
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        getItem(position).let(holder::bindView)
    }
}