package com.lcabral.features.upcoming.di

import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.upcoming.data.mapper.UpcomingMapper
import com.lcabral.features.upcoming.data.repository.UpcomingRepositoryImpl
import com.lcabral.features.upcoming.data.service.UpcomingService
import com.lcabral.features.upcoming.data.source.UpcomingDataSource
import com.lcabral.features.upcoming.data.source.UpcomingDataSourceImpl
import com.lcabral.features.upcoming.domain.repository.UpcomingRepository
import com.lcabral.features.upcoming.domain.usecase.GetUpcomingUseCase
import org.koin.core.scope.Scope

object UpcomingModule {
    val modules get() = listOf(dataModule)

    private fun Scope.getUpcomingUsecase(): GetUpcomingUseCase {
        return GetUpcomingUseCase(upcomingRepository = getRepository())
    }

    private fun Scope.getRepository(): UpcomingRepository {
        return UpcomingRepositoryImpl(
            upComingDataSource = getUpcomingDataSource()
        )
    }

    private fun Scope.getUpcomingDataSource(): UpcomingDataSource {
        return UpcomingDataSourceImpl(
            upcomingService = get<HttpClient>().create(UpcomingService::class.java),
            upcomingMapper = UpcomingMapper()
        )
    }
}
