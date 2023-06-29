package com.lcabral.trends.presentation.stubs

import com.lcabral.trends.domain.model.Trending

internal object TrendingTestData {
    fun getTrendings(): List<Trending> {
        return listOf(
            Trending(
                backdropPath = "jpg.",
                id= 1,
                overview = "Lorem Isosu",
                popularity = 9.8,
                posterPath = "jpg",
                releaseDate = null,
                title = null,
                voteAverage = 6.0
            ),
            Trending(
                backdropPath = "jpg.",
                id= 2,
                overview = "Lorem Isosu",
                popularity = 9.8,
                posterPath = "jpg",
                releaseDate = null,
                title = null,
                voteAverage = 6.0
            )
        )
    }
}