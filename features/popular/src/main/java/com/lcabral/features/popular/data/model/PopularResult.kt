package com.lcabral.features.popular.data.model

import com.google.gson.annotations.SerializedName

data class PopularResult(
    @SerializedName("results")
    val results: List<PopularResponse>
)
