package com.lcabral.trends.domain.repository

import com.lcabral.trends.domain.model.Trending
import kotlinx.coroutines.flow.Flow

internal interface TrendingsRepository {
    fun getTrendings(): Flow<List<Trending>>
}
