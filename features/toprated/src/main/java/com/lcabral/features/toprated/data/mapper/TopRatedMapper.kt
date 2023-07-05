package com.lcabral.features.toprated.data.mapper

import com.lcabral.core.data.remote.mapper.Mapper
import com.lcabral.features.toprated.data.model.TopRatedResponse
import com.lcabral.features.toprated.domain.model.TopRated

internal class TopRatedMapper : Mapper<List<TopRatedResponse>, List<TopRated>> {
    override fun map(source: List<TopRatedResponse>): List<TopRated> = source.map {
        mapPopular(it)
    }

    private fun mapPopular(source: TopRatedResponse) = TopRated(
        id = source.id,
        title = source.title,
        backdropPath = source.backdropPath.orEmpty(),
        overview = source.overview.orEmpty(),
        posterPath = source.posterPath.orEmpty(),
        releaseDate = source.releaseDate,
    )
}
