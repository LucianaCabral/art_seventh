package com.lcabral.features.movies.data.model

import com.google.gson.annotations.SerializedName

internal data class MovieResult(
    @SerializedName("results")
    val results: List<MovieResponse>
)
