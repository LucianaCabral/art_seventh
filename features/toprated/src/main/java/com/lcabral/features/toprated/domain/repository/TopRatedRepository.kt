package com.lcabral.features.toprated.domain.repository

import com.lcabral.features.toprated.domain.model.TopRated
import kotlinx.coroutines.flow.Flow

internal interface TopRatedRepository {
    fun getTopRated(): Flow<List<TopRated>>
}
