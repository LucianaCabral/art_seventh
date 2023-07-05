package com.lcabral.features.toprated.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lcabral.features.toprated.R
import com.lcabral.features.toprated.databinding.FragmentTopRatedBinding
import com.lcabral.features.toprated.presentation.adapter.TopRatedAdapter
import com.lcabral.features.toprated.presentation.extensions.showError
import com.lcabral.features.toprated.presentation.viewmodel.TopRatedState
import com.lcabral.features.toprated.presentation.viewmodel.TopRatedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TopRatedFragment : Fragment(R.layout.fragment_top_rated) {
    private var _binding: FragmentTopRatedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TopRatedViewModel by viewModel()
    private val topRatedAdapter by lazy { TopRatedAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTopRated()
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
                if (state.getTopRatedResultItems?.isNotEmpty() == true) {
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

    private fun updateList(state: TopRatedState) {
        state.getTopRatedResultItems?.let { topRatedAdapter.updateAdapter(it) }
    }

    private fun setupRecyclerView() {
        binding.recyclerTopRated.apply {
            setHasFixedSize(true)
            adapter = topRatedAdapter
//            layoutManager = GridLayoutManager(context, NUMBER_ROWS, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    companion object {
        fun newInstance(): TopRatedFragment = TopRatedFragment()
    }
}
