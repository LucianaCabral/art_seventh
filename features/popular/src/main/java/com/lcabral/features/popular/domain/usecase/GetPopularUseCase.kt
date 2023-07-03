package com.lcabral.features.popular.domain.usecase

import com.lcabral.features.popular.domain.model.Popular
import com.lcabral.features.popular.domain.repository.PopularRepository
import kotlinx.coroutines.flow.Flow

internal class GetPopularUseCase(
    private val popularRepository: PopularRepository
) {
    operator fun invoke(): Flow<List<Popular>> {
        return popularRepository.getPopular()
    }
}
