package com.lcabral.features.upcoming.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lcabral.features.upcoming.R
import com.lcabral.features.upcoming.databinding.FragmentUpcomingBinding
import com.lcabral.features.upcoming.presentation.adapter.UpcomingAdapter
import com.lcabral.features.upcoming.presentation.extensions.showError
import com.lcabral.features.upcoming.presentation.viewmodel.UpcomingViewModel
import com.lcabral.features.upcoming.presentation.viewmodel.UpcomingViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class UpComingFragment : Fragment(R.layout.fragment_upcoming) {

    private var _binding: FragmentUpcomingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UpcomingViewModel by viewModel()
    private val upcomingAdapter by lazy { UpcomingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        handleUpcoming()
    }

    private fun onErrorPopularLoading() {
        binding.progressCircular.visibility = View.GONE
        showError()
    }

    private fun onSuccessPopularLoading() {
        binding.progressCircular.visibility = View.GONE
    }

    private fun updateList(state: UpcomingViewState) {
        state.getUpcomingResultItems?.let { upcomingAdapter.updateAdapter(it) }
    }

    private fun handleUpcoming() {
        viewModel.viewState.observe(this) { state ->
            state?.let {
                if (state.getUpcomingResultItems?.isNotEmpty() == true) {
                    updateList(it)
                    onSuccessPopularLoading()
                } else {
                    onErrorPopularLoading()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerUpcoming.apply {
            setHasFixedSize(true)
            adapter = upcomingAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUpcoming()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): UpComingFragment = UpComingFragment()
    }
}
