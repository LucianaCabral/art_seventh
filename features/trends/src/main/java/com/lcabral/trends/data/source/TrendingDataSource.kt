package com.lcabral.trends.data.source

import com.lcabral.trends.domain.model.Trending
import kotlinx.coroutines.flow.Flow

internal interface TrendingDataSource {
    fun getTrending(): Flow<List<Trending>>
}
