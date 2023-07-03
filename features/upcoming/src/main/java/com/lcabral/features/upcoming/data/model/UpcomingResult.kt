package com.lcabral.features.upcoming.data.model

import com.google.gson.annotations.SerializedName
import com.lcabral.features.upcoming.domain.model.Upcoming

internal data class UpcomingResult(
    @SerializedName("results")
    val results: List<Upcoming>
)
