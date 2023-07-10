package com.lcabral.features.movies.domain.model

internal data class Movie(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val title: String?,
)

