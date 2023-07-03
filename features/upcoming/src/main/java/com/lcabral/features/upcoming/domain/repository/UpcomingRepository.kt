package com.lcabral.features.upcoming.domain.repository

import com.lcabral.features.upcoming.domain.model.Upcoming
import kotlinx.coroutines.flow.Flow

internal interface UpcomingRepository {
    fun getUpcoming(): Flow<List<Upcoming>>
}
