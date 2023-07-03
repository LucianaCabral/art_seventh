package com.lcabral.features.popular.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.features.popular.databinding.ItemPopularBinding
import com.lcabral.features.popular.domain.model.Popular

internal class PopularAdapter : ListAdapter<Popular, PopularViewHolder>(PopularDiffCallBack()) {

    private val popularList = ArrayList<Popular>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = popularList.size

    override fun getItem(position: Int): Popular {
        return popularList[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(popular: List<Popular>) {
        popularList.clear()
        popularList.addAll(popular)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        getItem(position).let(holder::bindView)
    }
}
