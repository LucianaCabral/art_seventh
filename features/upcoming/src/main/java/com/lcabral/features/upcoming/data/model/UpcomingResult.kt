package com.lcabral.features.upcoming.data.model

import com.google.gson.annotations.SerializedName

internal data class UpcomingResult(
    @SerializedName("results")
    val results: List<UpcomingResponse>
)
