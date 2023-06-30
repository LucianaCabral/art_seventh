package com.lcabral.features.popular.data.repository

import com.lcabral.features.popular.data.source.PopularDataSource
import com.lcabral.features.popular.domain.model.Popular
import com.lcabral.features.popular.domain.repository.PopularRepository
import kotlinx.coroutines.flow.Flow

internal class PopularRepositoryImpl(
    private val popularDataSource: PopularDataSource
) : PopularRepository {
    override fun getPopular(): Flow<List<Popular>> {
      return popularDataSource.getPopular()
    }
}
