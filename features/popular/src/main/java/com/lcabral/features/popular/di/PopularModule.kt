package com.lcabral.features.popular.di

import com.lcabral.core.common.navigation.PopularNavigation
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.popular.data.mapper.PopularMapper
import com.lcabral.features.popular.data.repository.PopularRepositoryImpl
import com.lcabral.features.popular.data.service.PopularService
import com.lcabral.features.popular.data.source.PopularDataSource
import com.lcabral.features.popular.data.source.PopularDataSourceImpl
import com.lcabral.features.popular.domain.repository.PopularRepository
import com.lcabral.features.popular.domain.usecase.GetPopularUseCase
import com.lcabral.features.popular.navigation.PopularNavigationImpl
import com.lcabral.features.popular.presentation.viewmodel.PopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object PopularModule {
    val modules get() = listOf(presentationModules, dataModule, additionalModules)

    private val presentationModules : Module = module {

        viewModel {
            PopularViewModel(getPopularUsecase())
        }
    }

    private val additionalModules:  Module = module {
        factory<PopularNavigation> { PopularNavigationImpl() }
    }

    private fun Scope.getPopularUsecase(): GetPopularUseCase {
        return GetPopularUseCase(popularRepository = getRepository())
    }

    private fun Scope.getRepository(): PopularRepository {
        return PopularRepositoryImpl(
            popularDataSource = getPopularDataSource()
        )
    }

    private fun Scope.getPopularDataSource(): PopularDataSource {
        return PopularDataSourceImpl(
            popularService = get<HttpClient>().create(PopularService::class.java),
            popularMapper = PopularMapper()
        )
    }
}
