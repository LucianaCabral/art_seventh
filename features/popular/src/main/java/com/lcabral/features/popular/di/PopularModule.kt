package com.lcabral.features.popular.di

import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.popular.data.mapper.PopularMapper
import com.lcabral.features.popular.data.repository.PopularRepositoryImpl
import com.lcabral.features.popular.data.service.PopularService
import com.lcabral.features.popular.data.source.PopularDataSource
import com.lcabral.features.popular.data.source.PopularDataSourceImpl
import com.lcabral.features.popular.domain.repository.PopularRepository
import com.lcabral.features.popular.domain.usecase.GetPopularUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object PopularModule {
    val modules get() = listOf(presentationModules, dataModule)

    private val presentationModules : Module = module {

        viewModel {
            TODO()
        }
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