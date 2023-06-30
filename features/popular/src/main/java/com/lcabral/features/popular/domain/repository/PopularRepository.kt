package com.lcabral.features.popular.domain.repository

import com.lcabral.features.popular.domain.model.Popular
import kotlinx.coroutines.flow.Flow

internal interface PopularRepository {
    fun getPopular(): Flow<List<Popular>>
}
