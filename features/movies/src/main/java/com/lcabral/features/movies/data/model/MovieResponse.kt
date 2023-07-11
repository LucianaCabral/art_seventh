package com.lcabral.features.movies.data.model

import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
)
