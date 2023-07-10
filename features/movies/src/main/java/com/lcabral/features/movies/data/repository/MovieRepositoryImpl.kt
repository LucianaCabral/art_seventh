package com.lcabral.features.movies.data.repository

import com.lcabral.features.movies.data.mapper.MovieMapper
import com.lcabral.features.movies.data.service.MovieService
import com.lcabral.features.movies.data.source.MovieDataSource
import com.lcabral.features.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class MovieRepositoryImpl (
    private val movieService: MovieService,
    private val movieMapper: MovieMapper
) : MovieDataSource {
    override fun getMovies(): Flow<List<Movie>> {
        return flow {
            emit(movieService.getMovie())
        }.map { movieResponse ->
            movieMapper.map(movieResponse.results)
        }
    }
}
