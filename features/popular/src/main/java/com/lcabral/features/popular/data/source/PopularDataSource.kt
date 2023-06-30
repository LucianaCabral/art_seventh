package com.lcabral.features.popular.data.source

import com.lcabral.features.popular.domain.model.Popular
import kotlinx.coroutines.flow.Flow

internal interface PopularDataSource {
    fun getPopular(): Flow<List<Popular>>
}
