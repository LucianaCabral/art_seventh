package com.lcabral.features.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lcabral.features.movies.R
import com.lcabral.features.movies.databinding.FragmentMovieBinding
import com.lcabral.features.movies.presentation.adapter.MovieAdapter
import com.lcabral.features.movies.presentation.extensions.showError
import com.lcabral.features.movies.presentation.viewmodel.MovieStateView
import com.lcabral.features.movies.presentation.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MovieFragment : Fragment(R.layout.fragment_movie) {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by viewModel()
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        handleMovie()
    }

    private fun handleMovie() {
        viewModel.viewState.observe(this) { state ->
            state?.let {
                if (state.getMoviesResultItems?.isNotEmpty() == true) {
                    updateList(it)
                    onSuccessMoviesLoading()
                } else {
                    onErrorMoviesLoading()
                }
            }
        }
    }

    private fun onSuccessMoviesLoading() {
        binding.progressCircular.visibility = View.GONE
    }

    private fun onErrorMoviesLoading() {
        binding.progressCircular.visibility = View.GONE
        showError()
    }

    private fun updateList(items: MovieStateView) {
        items.getMoviesResultItems?.let { movieAdapter.updateAdapter(it) }
    }

    private fun setupRecyclerView() {
        binding.recyclerMovie.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

        companion object {
            fun newInstance(): MovieFragment = MovieFragment()
        }
}
