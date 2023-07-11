package com.lcabral.features.movies.presentation

import com.lcabral.features.movies.domain.model.Movie

internal object MovieTestData {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                description = "",
                id= 1,
                posterPath = "jpg",
                name = "null",
            ),
            Movie(
                id= 2,
                description = "",
                posterPath = "jpg",
                name = "null",
            )
        )
    }
}

