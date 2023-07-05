package com.lcabral.features.toprated.di

import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.toprated.data.mapper.TopRatedMapper
import com.lcabral.features.toprated.data.repository.TopRatedRepositotyImpl
import com.lcabral.features.toprated.data.service.TopRatedService
import com.lcabral.features.toprated.data.source.TopRatedDataSource
import com.lcabral.features.toprated.data.source.TopRatedDataSourceImpl
import com.lcabral.features.toprated.domain.repository.TopRatedRepository
import com.lcabral.features.toprated.domain.usecase.GetTopRatedUseCase
import org.koin.core.scope.Scope

object TopRatedModule {
    val modules get() = listOf(dataModule)

    private fun Scope.getUseTrendingCase(): GetTopRatedUseCase {
        return GetTopRatedUseCase(topRatedRepository = getRepository())
    }

    private fun Scope.getRepository(): TopRatedRepository {
        return TopRatedRepositotyImpl(
           topRatedDataSource = getTopRatedDataSource()
        )
    }

    private fun Scope.getTopRatedDataSource(): TopRatedDataSource {
        return TopRatedDataSourceImpl(
            topRatedService = get<HttpClient>().create(TopRatedService::class.java),
            topRatedMapper = TopRatedMapper()
        )
    }
}