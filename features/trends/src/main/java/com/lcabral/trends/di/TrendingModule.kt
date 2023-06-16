package com.lcabral.trends.di

import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.trends.data.mapper.TrendingMapper
import com.lcabral.trends.data.repository.TrendingRepositoryImpl
import com.lcabral.trends.data.service.TrendingService
import com.lcabral.trends.data.source.TrendingDataSource
import com.lcabral.trends.data.source.TrendingDataSourceImpl
import com.lcabral.trends.domain.repository.TrendingsRepository
import com.lcabral.trends.domain.usecase.GetTrendingUseCase
import com.lcabral.trends.navigation.TrendingNavigationImpl
import com.lcabral.trends.presentation.viewmodel.TrendingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object TrendingModule {
    val modules get() = listOf(presentationModules, additionalModules)

    private val presentationModules : Module = module {

        viewModel {
            TrendingViewModel(getUseTrendingCase())
        }
    }

    private val additionalModules:  Module = module {
        factory<TrendsNavigation> { TrendingNavigationImpl() }
    }

    private fun Scope.getUseTrendingCase(): GetTrendingUseCase {
        return GetTrendingUseCase(trendingsRepository = getRepository())
    }

    private fun Scope.getRepository(): TrendingsRepository {
        return TrendingRepositoryImpl(
            dataSource = getTrendingDataSource()
        )
    }

    private fun Scope.getTrendingDataSource(): TrendingDataSource {
        return TrendingDataSourceImpl(
            trendingService = get<HttpClient>().create(TrendingService::class.java),
            trendingMapper = TrendingMapper()
        )
    }
}
