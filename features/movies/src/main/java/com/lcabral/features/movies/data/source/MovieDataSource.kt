package com.lcabral.features.movies.data.source

import com.lcabral.features.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

internal interface MovieDataSource {
    fun getMovies(): Flow<List<Movie>>
}
