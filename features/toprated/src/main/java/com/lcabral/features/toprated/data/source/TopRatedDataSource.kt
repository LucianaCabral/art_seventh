package com.lcabral.features.toprated.data.source

import com.lcabral.features.toprated.domain.model.TopRated
import kotlinx.coroutines.flow.Flow

internal interface TopRatedDataSource {
    fun getTopRated(): Flow<List<TopRated>>
}
