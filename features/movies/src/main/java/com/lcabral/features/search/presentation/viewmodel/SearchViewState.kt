package com.lcabral.features.search.presentation.viewmodel

import com.lcabral.features.movies.domain.model.Movie

internal data class SearchViewState(
    val isLoadingVisible: Boolean = false,
    val isErrorVisible:Boolean = false,
    val searchResultItems: List<Movie>? = null
)
