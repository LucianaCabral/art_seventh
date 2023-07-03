package com.lcabral.features.upcoming.domain.usecase

import com.lcabral.features.upcoming.domain.model.Upcoming
import com.lcabral.features.upcoming.domain.repository.UpcomingRepository
import kotlinx.coroutines.flow.Flow

internal class GetUpcomingUseCase(
    private val upcomingRepository: UpcomingRepository
) {
    operator fun invoke(): Flow<List<Upcoming>> {
        return upcomingRepository.getUpcoming()
    }
}
