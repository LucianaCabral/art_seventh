package com.lcabral.trends.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.trends.R
import com.lcabral.trends.databinding.FragmentTrendingBinding
import com.lcabral.trends.presentation.adapter.TrendingAdapter
import com.lcabral.trends.presentation.extensions.showError
import com.lcabral.trends.presentation.viewmodel.TrendingViewModel
import com.lcabral.trends.presentation.viewmodel.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TrendingFragment : Fragment(R.layout.fragment_trending) {

    private var _binding: FragmentTrendingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TrendingViewModel by viewModel()

    private val trendingAdapter by lazy { TrendingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTrendings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()

    }

    private fun setupObservers() {
        handleTrending()
    }

    private fun handleTrending() {
        viewModel.viewState.observe(this) { state ->
            state?.let {
                if (state.getTrendingsResultItems?.isNotEmpty() == true) {
                    updateList(it)
                    onSuccessTrendingLoading()
                } else {
                   onErrorTrendingLoading()
                }
            }
        }
    }

    private fun onSuccessTrendingLoading() {
        binding.progressCircular.visibility = View.GONE
    }

    private fun onErrorTrendingLoading() {
        binding.progressCircular.visibility = View.GONE
        showError()
    }

    private fun updateList(items: ViewState) {
        items.getTrendingsResultItems?.let { trendingAdapter.updateAdapter(it) }
    }

    private fun setupRecyclerView() {
        binding.recyclerTrending.apply {
            setHasFixedSize(true)
            adapter = trendingAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    companion object {
        fun newInstance(): TrendingFragment = TrendingFragment()
    }
}
