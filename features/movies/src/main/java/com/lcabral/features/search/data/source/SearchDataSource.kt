package com.lcabral.features.search.data.source

import com.lcabral.features.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

internal interface SearchDataSource {
    fun searchMovies(query:String): Flow<List<Movie>>
}