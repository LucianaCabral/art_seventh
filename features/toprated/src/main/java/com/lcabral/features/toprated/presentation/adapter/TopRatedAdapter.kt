package com.lcabral.features.toprated.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.features.toprated.databinding.ItemTopRatedBinding
import com.lcabral.features.toprated.domain.model.TopRated

internal class TopRatedAdapter : ListAdapter<TopRated, TopRatedViewHolder>(TopRatedDiffUtil()) {

    private val topRatedList = ArrayList<TopRated>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val binding =
            ItemTopRatedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopRatedViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = topRatedList.size

    override fun getItem(position: Int): TopRated {
        return topRatedList[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(topRated: List<TopRated>) {
        topRatedList.clear()
        topRatedList.addAll(topRated)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        getItem(position).let(holder::bindView)
    }
}
