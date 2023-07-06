package com.lcabral.features.toprated.domain.usecase

import com.lcabral.features.toprated.domain.model.TopRated
import com.lcabral.features.toprated.domain.repository.TopRatedRepository
import kotlinx.coroutines.flow.Flow

internal class GetTopRatedUseCase(
    private val topRatedRepository: TopRatedRepository
) {
    operator fun invoke(): Flow<List<TopRated>> {
        return topRatedRepository.getTopRated()
    }
}
