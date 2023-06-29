package com.lcabral.trends.data.model

import com.google.gson.annotations.SerializedName

internal data class TrendingsResult(
    @SerializedName("results")
    val results: List<TrendingResponse>
)
