package com.lcabral.features.search.data.repository


import com.lcabral.features.movies.data.source.MovieDataSource
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.search.data.source.SearchDataSource
import com.lcabral.features.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

internal class SearchRepositoryImpl(
    private val searchDataSource: SearchDataSource
) : SearchRepository {

    override fun searchMovies(query: String): Flow<List<Movie>> {
        return searchDataSource.searchMovies(query)
    }
}
