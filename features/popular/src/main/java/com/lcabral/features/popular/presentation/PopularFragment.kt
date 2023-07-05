package com.lcabral.features.popular.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.features.popular.R
import com.lcabral.features.popular.databinding.FragmentPopularBinding
import com.lcabral.features.popular.presentation.adapter.PopularAdapter
import com.lcabral.features.popular.presentation.extensions.showError
import com.lcabral.features.popular.presentation.viewmodel.PopularViewModel
import com.lcabral.features.popular.presentation.viewmodel.PopularViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val NUMBER_ROWS = 2

internal class PopularFragment : Fragment(R.layout.fragment_popular) {

    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PopularViewModel by viewModel()
    private val popularAdapter by lazy { PopularAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPopular()
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
        handlePopular()
    }

    private fun handlePopular() {
        viewModel.viewState.observe(this) { state ->
            state?.let {
                if (state.getPopularResultItems?.isNotEmpty() == true) {
                    updateList(it)
                    onSuccessPopularLoading()
                } else {
                    onErrorPopularLoading()
                }
            }
        }
    }

    private fun onSuccessPopularLoading() {
        binding.progressCircular.visibility = View.GONE
    }

    private fun onErrorPopularLoading() {
        binding.progressCircular.visibility = View.GONE
        showError()
    }

    private fun updateList(state: PopularViewState) {
        state.getPopularResultItems?.let { popularAdapter.updateAdapter(it) }
    }

    private fun setupRecyclerView() {
        binding.recyclerPopular.apply {
            setHasFixedSize(true)
            adapter = popularAdapter
            layoutManager = GridLayoutManager(context, NUMBER_ROWS, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    companion object {
        fun newInstance(): PopularFragment = PopularFragment()
    }
}
