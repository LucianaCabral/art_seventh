package com.lcabral.features.search.domain.repository

import com.lcabral.features.movies.data.model.MovieResult
import com.lcabral.features.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

internal interface SearchRepository {
    fun searchMovies(query:String): Flow<List<Movie>>
}
