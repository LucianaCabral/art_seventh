package com.lcabral.trends.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.trends.R
import com.lcabral.trends.databinding.FragmentTrendingBinding
import com.lcabral.trends.databinding.ItemTrendingCarouselBinding.*
import com.lcabral.trends.presentation.adapter.TrendingAdapter
import com.lcabral.trends.presentation.extensions.showError
import com.lcabral.trends.presentation.viewmodel.TrendingAction
import com.lcabral.trends.presentation.viewmodel.TrendingViewModel
import com.lcabral.trends.presentation.viewmodel.ViewTrendingState
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 * Use the [TrendingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrendingFragment : Fragment(R.layout.fragment_trending) {


    private lateinit var binding: FragmentTrendingBinding
    private val trendingViewModel: TrendingViewModel by inject()
    private val trendingNavigation: TrendsNavigation by inject()
    private val adapter: TrendingAdapter by lazy { TrendingAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTrendingBinding.bind(view)

        setupView()
        setupObservers()
    }

    private fun setupView() {
        setupRecycler()
    }

    private fun handleState() {
        trendingViewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            with(viewState) {
                updateVisibility()
                if (isErrorVisible) showError()
                getTrendingsResultItems?.let(adapter::submitList)
            }
        })
    }

    private fun setupRecycler() {
        binding.trendingRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TrendingFragment.adapter
        }
    }

    private fun setupObservers() {
        handleState()
    }


    private fun handleAction(action: TrendingAction) {
        when (action) {
            is TrendingAction.NavigateToHome -> navigateToTrends()

        }
    }

    private fun navigateToTrends() = context?.let {
        val intent = trendingNavigation.navigateToTrend()
    }

    private fun ViewTrendingState.updateVisibility() {
        binding.trendingRv.isVisible = getTrendingsResultItems?.isNotEmpty() == true
    }


    companion object {
        @JvmStatic
        fun newInstance() = TrendingFragment()
    }
}