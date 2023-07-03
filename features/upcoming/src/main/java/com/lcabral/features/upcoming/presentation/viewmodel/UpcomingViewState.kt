package com.lcabral.features.upcoming.presentation.viewmodel

import com.lcabral.features.upcoming.domain.model.Upcoming

internal data class UpcomingViewState(
    val isLoading: Boolean = false,
    val upcomingFailure: Boolean = false,
    val getUpcomingResultItems: List<Upcoming>? = null
)
