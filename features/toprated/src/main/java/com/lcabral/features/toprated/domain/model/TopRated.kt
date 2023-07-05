package com.lcabral.features.toprated.domain.model

internal data class TopRated(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val title: String?,
)

