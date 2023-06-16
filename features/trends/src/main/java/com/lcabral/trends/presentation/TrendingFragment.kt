package com.lcabral.trends.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.lcabral.trends.R
import com.lcabral.trends.databinding.FragmentTrendingBinding
import com.lcabral.trends.presentation.adapter.TrendingAdapter
import com.lcabral.trends.presentation.extensions.showError
import com.lcabral.trends.presentation.viewmodel.TrendingViewModel
import com.lcabral.trends.presentation.viewmodel.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrendingFragment : Fragment(R.layout.fragment_trending) {

    private lateinit var binding: FragmentTrendingBinding
    private val viewModel: TrendingViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy { binding.recyclerTrending }
    private val trendingAdapter by lazy { TrendingAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecycler()
    }

    private fun handleState() {
        viewModel.viewState.observe(this, Observer { state ->
            Log.i("Lou", "onStart: $state\n ")
            with(state) {
                updateVisibility()
                if (isErrorVisible) showError()
//                getTrendingsResultItems?.let(trendingAdapter::submitList)
                trendingAdapter.submitList(state.getTrendingsResultItems)
            }
        })
    }

    private fun setupRecycler() = binding.run {
        recyclerView.adapter = trendingAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = null
    }

    private fun setupObservers() {
        handleState()
    }

    private fun ViewState.updateVisibility() {
        recyclerView.isVisible = let { getTrendingsResultItems?.isNotEmpty() == true }
    }


    companion object {
        fun newInstance(): TrendingFragment = TrendingFragment()
    }
}
