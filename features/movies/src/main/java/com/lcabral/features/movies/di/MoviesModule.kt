package com.lcabral.features.movies.di

import com.lcabral.core.common.navigation.MovieNavigation
import com.lcabral.core.common.navigation.SearchNavigation
import com.lcabral.core.data.remote.HttpClient
import com.lcabral.core.data.remote.di.dataModule
import com.lcabral.features.movies.data.mapper.MovieMapper
import com.lcabral.features.movies.data.repository.MovieRepositoryImpl
import com.lcabral.features.movies.data.service.MovieService
import com.lcabral.features.movies.data.source.MovieDataSource
import com.lcabral.features.movies.data.source.MovieDataSourceImpl
import com.lcabral.features.movies.domain.repository.MovieRepository
import com.lcabral.features.movies.domain.usecase.GetMovieUseCase
import com.lcabral.features.movies.navigation.MovieNavigationImpl
import com.lcabral.features.movies.presentation.viewmodel.MovieViewModel
import com.lcabral.features.search.navigation.SearchNavigationImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.Scope
import org.koin.dsl.module

object MoviesModule {
    val modules get() = listOf(presentationModules, dataModule, additionalModules)

    private val presentationModules : Module = module {

        viewModel {
            MovieViewModel(getMovieUsecase())
        }
    }

    private val additionalModules: Module = module {
        factory<MovieNavigation> { MovieNavigationImpl() }
        factory<SearchNavigation> { SearchNavigationImpl() }
    }

    private fun Scope.getMovieUsecase():GetMovieUseCase{
        return GetMovieUseCase(movieRepository = getRepository())
    }

    private fun Scope.getRepository(): MovieRepository {
        return MovieRepositoryImpl(
           getMovieDataSource()
        )
    }

    private fun Scope.getMovieDataSource(): MovieDataSource {
        return MovieDataSourceImpl(
            movieService = get<HttpClient>().create(MovieService::class.java),
            movieMapper = MovieMapper()
        )
    }
}
