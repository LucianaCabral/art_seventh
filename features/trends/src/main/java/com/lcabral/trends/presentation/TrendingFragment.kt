package com.lcabral.trends.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.trends.databinding.FragmentTrendingBinding
import com.lcabral.trends.presentation.adapter.TrendingAdapter
import com.lcabral.trends.presentation.viewmodel.TrendingViewModel
import com.lcabral.trends.presentation.viewmodel.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TrendingFragment : Fragment() {

    private var _binding: FragmentTrendingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TrendingViewModel by viewModel()

    private val trendingAdapter by lazy { TrendingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
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
        setupObservers()
        Toast.makeText(requireContext(), "ENTRY", Toast.LENGTH_LONG).show()
    }

    private fun setupObservers() {
        viewModel.viewState.observe(this, Observer { state ->
            with(state) {
                updateVisibility()
                with(trendingAdapter) { submitList(state.getTrendingsResultItems) }
                Toast.makeText(requireContext(), "success", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerTrending.apply {
            adapter = trendingAdapter
            recyclerTrending.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun ViewState.updateVisibility() {
        binding.recyclerTrending.isVisible = getTrendingsResultItems?.isNotEmpty() == true
    }

    companion object {
        fun newInstance(): TrendingFragment = TrendingFragment()
    }

}
