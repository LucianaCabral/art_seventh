package com.lcabral.features.popular.data.mapper

import com.lcabral.core.data.remote.mapper.Mapper
import com.lcabral.features.popular.data.model.PopularResponse
import com.lcabral.features.popular.domain.model.Popular

internal class PopularMapper : Mapper<List<PopularResponse>, List<Popular>> {
    override fun map(source: List<PopularResponse>): List<Popular> = source.map {
        mapPopular(it)
    }

    private fun mapPopular(source: PopularResponse) = Popular(
        id = source.id,
        title = source.title,
        backdropPath = source.backdropPath.orEmpty(),
        overview = source.overview.orEmpty(),
        posterPath = source.posterPath.orEmpty(),
        releaseDate = source.releaseDate,
    )
}
