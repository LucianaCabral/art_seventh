package com.lcabral.features.toprated.di

import com.lcabral.core.common.navigation.TopRatedNavigation
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.toprated.data.mapper.TopRatedMapper
import com.lcabral.features.toprated.data.repository.TopRatedRepositotyImpl
import com.lcabral.features.toprated.data.service.TopRatedService
import com.lcabral.features.toprated.data.source.TopRatedDataSource
import com.lcabral.features.toprated.data.source.TopRatedDataSourceImpl
import com.lcabral.features.toprated.domain.repository.TopRatedRepository
import com.lcabral.features.toprated.domain.usecase.GetTopRatedUseCase
import com.lcabral.features.toprated.navigation.TopRatedNavigationImpl
import com.lcabral.features.toprated.presentation.viewmodel.TopRatedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object TopRatedModule {
    val modules get() = listOf(dataModule, presentationModules, additionalModules)

    private val presentationModules : Module = module {

        viewModel {
            TopRatedViewModel(getUseTopRatedCase())
        }
    }

    private val additionalModules:  Module = module {
        factory<TopRatedNavigation> { TopRatedNavigationImpl() }
    }

    private fun Scope.getUseTopRatedCase(): GetTopRatedUseCase {
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
