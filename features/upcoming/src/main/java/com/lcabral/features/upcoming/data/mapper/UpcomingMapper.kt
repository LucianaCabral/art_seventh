package com.lcabral.features.upcoming.data.mapper

import com.lcabral.core.data.remote.mapper.Mapper
import com.lcabral.features.upcoming.data.model.UpcomingResponse
import com.lcabral.features.upcoming.domain.model.Upcoming

internal class UpcomingMapper : Mapper<List<UpcomingResponse>, List<Upcoming>> {
    override fun map(source: List<UpcomingResponse>): List<Upcoming> = source.map {
        mapPopular(it)
    }

    private fun mapPopular(source: UpcomingResponse) = Upcoming(
        id = source.id,
        title = source.title,
        backdropPath = source.backdropPath.orEmpty(),
        overview = source.overview.orEmpty(),
        posterPath = source.posterPath.orEmpty(),
        releaseDate = source.releaseDate,
    )
}
