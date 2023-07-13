package com.lcabral.features.search.domain.usecase

import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

internal class SearchMoviesUseCase(
    private val searchRepository: SearchRepository
) {
    operator fun invoke(
        query: String
    ): Flow<List<Movie>> {
        return searchRepository.searchMovies(query)
    }
}