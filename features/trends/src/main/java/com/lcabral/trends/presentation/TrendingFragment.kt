package com.lcabral.trends.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.trends.R
import com.lcabral.trends.databinding.FragmentTrendingBinding
import com.lcabral.trends.presentation.adapter.TrendingAdapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupObservers() {
        viewModel.viewState.observe(this, Observer { state ->
            state?.let {
                if (state.getTrendingsResultItems.isNotEmpty()) {
                    updateList(it)
                }
            }
        })
    }

    private fun updateList(items: ViewState) {
        trendingAdapter.updateAdapter(items.getTrendingsResultItems)
    }

    override fun onStart() {
        super.onStart()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.recyclerTrending.apply {
            setHasFixedSize(true)
            adapter = trendingAdapter
            layoutManager = LinearLayoutManager(requireContext())
            LinearLayoutManager.VERTICAL
        }
    }

    companion object {
        fun newInstance(): TrendingFragment = TrendingFragment()
    }
}
