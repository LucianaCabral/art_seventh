package com.lcabral.trends.data.repository

import com.lcabral.trends.data.source.TrendingDataSource
import com.lcabral.trends.domain.model.Trending
import com.lcabral.trends.domain.repository.TrendingsRepository
import kotlinx.coroutines.flow.Flow

internal class TrendingRepositoryImpl(
    private val dataSource: TrendingDataSource
) : TrendingsRepository {
    override fun getTrendings(): Flow<List<Trending>> {
        return dataSource.getTrending()
    }
}
