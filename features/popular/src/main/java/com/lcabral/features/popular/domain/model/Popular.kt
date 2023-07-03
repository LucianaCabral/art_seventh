package com.lcabral.features.popular.domain.model

internal data class Popular(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val title: String?,
)
