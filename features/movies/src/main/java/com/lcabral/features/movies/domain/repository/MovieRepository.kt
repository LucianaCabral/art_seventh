package com.lcabral.features.movies.domain.repository

import com.lcabral.features.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

internal interface MovieRepository {
    fun getMovies(): Flow<List<Movie>>
}
