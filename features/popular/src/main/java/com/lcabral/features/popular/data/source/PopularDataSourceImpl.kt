package com.lcabral.features.popular.data.source

import com.lcabral.features.popular.data.mapper.PopularMapper
import com.lcabral.features.popular.data.service.PopularService
import com.lcabral.features.popular.domain.model.Popular
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class PopularDataSourceImpl(
    private val popularService: PopularService,
    private val popularMapper: PopularMapper
) : PopularDataSource {
    override fun getPopular(): Flow<List<Popular>> {
        return flow {
            emit(popularService.getPopular())
        }.map { popularResponse ->
            popularMapper.map(popularResponse.results)
        }
    }
}
