package com.lcabral.trends.domain.model

internal data class Trending(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String?,
    val title: String?,
    val voteAverage: Double,
)
