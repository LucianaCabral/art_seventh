package com.lcabral.trends.data.source

import com.lcabral.trends.data.mapper.TrendingMapper
import com.lcabral.trends.data.service.TrendingService

import com.lcabral.trends.domain.model.Trending
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class TrendingDataSourceImpl(
    private val trendingService:TrendingService,
    private val trendingMapper: TrendingMapper
) : TrendingDataSource {
    override fun getTrending(): Flow<List<Trending>> {
        return flow {
            emit(trendingService.getTrendings())

        }.map { trendingResponse ->
            trendingMapper.map(trendingResponse.results)
        }
    }
}

