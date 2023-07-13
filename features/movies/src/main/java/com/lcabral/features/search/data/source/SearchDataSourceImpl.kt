package com.lcabral.features.search.data.source

import com.lcabral.features.movies.data.mapper.MovieMapper
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.search.data.service.SearchService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class SearchDataSourceImpl(
    private val service: SearchService,
    private val searchMapper: MovieMapper
) : SearchDataSource {

    override fun searchMovies(query:String): Flow<List<Movie>> {
        return flow {
            emit(service.searchMovies(query))
        }.map { searchMovieResponse ->
            searchMapper.map(searchMovieResponse.results)
        }
    }
}