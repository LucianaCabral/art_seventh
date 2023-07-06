package com.lcabral.features.toprated.data.model

import com.google.gson.annotations.SerializedName

internal data class TopRatedResult(
    @SerializedName("results")
    val results: List<TopRatedResponse>
)
