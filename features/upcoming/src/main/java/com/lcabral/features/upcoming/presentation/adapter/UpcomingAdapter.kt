package com.lcabral.features.upcoming.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lcabral.features.upcoming.databinding.ItemUpcomingBinding
import com.lcabral.features.upcoming.domain.model.Upcoming

internal class UpcomingAdapter : ListAdapter<Upcoming, UpcomingViewHolder>(UpcomingDiffCallBack()) {

    private val upComingList = ArrayList<Upcoming>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val binding =
            ItemUpcomingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingViewHolder(binding = binding)
    }

    override fun getItem(position: Int): Upcoming {
        return upComingList[position]
    }

    override fun getItemCount(): Int = upComingList.size

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        getItem(position).let(holder::bindView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(upcoming: List<Upcoming>) {
        upComingList.clear()
       upComingList.addAll(upcoming)
        notifyDataSetChanged()
    }
}

