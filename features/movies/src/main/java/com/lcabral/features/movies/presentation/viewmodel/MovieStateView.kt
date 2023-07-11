package com.lcabral.features.movies.presentation.viewmodel

import com.lcabral.features.movies.domain.model.Movie

internal data class MovieStateView(
    val isLoading: Boolean = false,
    val moviesFailure: Boolean = false,
    val getMoviesResultItems: List<Movie>? = null
)
