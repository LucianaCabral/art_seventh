package com.lcabral.features.movies.domain.model

data class Movie(
    val id: Int,
    val description: String,
    val posterPath: String?,
    val name: String?,
)

