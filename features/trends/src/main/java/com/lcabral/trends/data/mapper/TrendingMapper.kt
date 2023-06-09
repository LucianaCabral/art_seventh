package com.lcabral.trends.data.mapper

import com.lcabral.trends.data.model.TrendingResponse
import com.lcabral.trends.domain.model.Trending

internal class TrendingMapper : Mapper<List<TrendingResponse>, List<Trending>> {
    override fun map(source: List<TrendingResponse>): List<Trending> = source.map{
        mapTrendings(it)
    }

    private fun mapTrendings(source: TrendingResponse) = Trending(
        id = source.id,
        title = source.title,
        backdropPath = source.backdropPath.orEmpty(),
        overview = source.overview.orEmpty(),
        popularity = source.popularity,
        posterPath = source.posterPath.orEmpty(),
        releaseDate = source.releaseDate,
        voteAverage = source.voteAverage,
    )
}
