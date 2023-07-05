package com.lcabral.features.toprated.data.repository

import com.lcabral.features.toprated.data.source.TopRatedDataSource
import com.lcabral.features.toprated.domain.model.TopRated
import com.lcabral.features.toprated.domain.repository.TopRatedRepository
import kotlinx.coroutines.flow.Flow

internal class TopRatedImpl(
    private val topRatedDataSource: TopRatedDataSource
) : TopRatedRepository {
    override fun getTopRated(): Flow<List<TopRated>> {
        return topRatedDataSource.getTopRated()
    }
}
