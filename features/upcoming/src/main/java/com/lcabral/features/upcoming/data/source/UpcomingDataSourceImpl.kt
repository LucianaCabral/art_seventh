package com.lcabral.features.upcoming.data.source

import com.lcabral.features.upcoming.data.mapper.UpcomingMapper
import com.lcabral.features.upcoming.data.service.UpcomingService
import com.lcabral.features.upcoming.domain.model.Upcoming
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class UpcomingDataSourceImpl(
    private val upcomingService: UpcomingService,
    private val upcomingMapper: UpcomingMapper
) : UpcomingDataSource {
    override fun getUpcoming(): Flow<List<Upcoming>> {
        return flow {
            emit(upcomingService.getUpcoming())
        }.map { upcomingResponse ->
            upcomingMapper.map(upcomingResponse.results)
        }
    }
}
