package com.lcabral.features.upcoming.di

import com.lcabral.core.common.navigation.UpcomingNavigation
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.upcoming.data.mapper.UpcomingMapper
import com.lcabral.features.upcoming.data.repository.UpcomingRepositoryImpl
import com.lcabral.features.upcoming.data.service.UpcomingService
import com.lcabral.features.upcoming.data.source.UpcomingDataSource
import com.lcabral.features.upcoming.data.source.UpcomingDataSourceImpl
import com.lcabral.features.upcoming.domain.repository.UpcomingRepository
import com.lcabral.features.upcoming.domain.usecase.GetUpcomingUseCase
import com.lcabral.features.upcoming.navigation.UpcomingNavigationImpl
import com.lcabral.features.upcoming.presentation.viewmodel.UpcomingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object UpcomingModule {
    val modules get() = listOf(presentationModules, additionalModules,dataModule)

    private val presentationModules : Module = module {

        viewModel {
            UpcomingViewModel(getUpcomingUsecase())
        }
    }

    private val additionalModules:  Module = module {
        factory<UpcomingNavigation> { UpcomingNavigationImpl() }
    }

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
