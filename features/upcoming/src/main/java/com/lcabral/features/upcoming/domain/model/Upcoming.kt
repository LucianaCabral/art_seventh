package com.lcabral.features.upcoming.domain.model

internal data class Upcoming(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val title: String?,
)
