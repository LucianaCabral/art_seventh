package com.lcabral.trends.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal data class TrendingResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("vote_average")
    val voteAverage: Double,
)

