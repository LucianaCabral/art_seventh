package com.lcabral.features.toprated.data.source

import com.lcabral.features.toprated.data.mapper.TopRatedMapper
import com.lcabral.features.toprated.data.service.TopRatedService
import com.lcabral.features.toprated.domain.model.TopRated
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class TopRatedDataSourceImpl(
    private val topRatedService: TopRatedService,
    private val topRatedMapper: TopRatedMapper
) : TopRatedDataSource {

    override fun getTopRated(): Flow<List<TopRated>> {
        return flow {
            emit(topRatedService.getTopRated())
        }.map { topRatedResponse ->
            topRatedMapper.map(topRatedResponse.results)
        }
    }
}
