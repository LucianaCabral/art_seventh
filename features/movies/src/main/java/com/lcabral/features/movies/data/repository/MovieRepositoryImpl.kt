package com.lcabral.features.movies.data.repository

import com.lcabral.features.movies.data.source.MovieDataSource
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

internal class MovieRepositoryImpl (
    private val movieDataSource: MovieDataSource
) : MovieRepository {
    override fun getMovies(): Flow<List<Movie>> {
       return movieDataSource.getMovies()
    }
}
