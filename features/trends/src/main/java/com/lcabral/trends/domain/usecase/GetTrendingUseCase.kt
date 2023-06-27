package com.lcabral.trends.domain.usecase

import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.domain.repository.TrendingsRepository
import kotlinx.coroutines.flow.Flow

internal class GetTrendingUseCase(
    private val trendingsRepository: TrendingsRepository
) {

    operator fun invoke(): Flow<List<Trending>> {
        return trendingsRepository.getTrendings()
    }
}
