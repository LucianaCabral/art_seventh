package com.lcabral.features.upcoming.data.source

import com.lcabral.features.upcoming.domain.model.Upcoming
import kotlinx.coroutines.flow.Flow

internal interface UpcomingDataSource {
    fun getUpcoming(): Flow<List<Upcoming>>
}
