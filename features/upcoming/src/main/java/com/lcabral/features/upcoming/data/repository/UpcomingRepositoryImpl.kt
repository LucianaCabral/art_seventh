package com.lcabral.features.upcoming.data.repository

import com.lcabral.features.upcoming.data.source.UpcomingDataSource
import com.lcabral.features.upcoming.domain.model.Upcoming
import com.lcabral.features.upcoming.domain.repository.UpcomingRepository
import kotlinx.coroutines.flow.Flow

internal class UpcomingRepositoryImpl(
    private val upComingDataSource: UpcomingDataSource
) : UpcomingRepository {
    override fun getUpcoming(): Flow<List<Upcoming>> {
        return upComingDataSource.getUpcoming()
    }
}