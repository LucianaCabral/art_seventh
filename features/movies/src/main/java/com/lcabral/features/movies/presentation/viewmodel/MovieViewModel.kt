package com.lcabral.features.movies.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.movies.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class MovieViewModel (
    private val movieUseCase: GetMovieUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _viewState : MutableLiveData<MovieStateView> = MutableLiveData<MovieStateView>()
    val viewState: LiveData<MovieStateView> = _viewState

     fun getMovies() {
        viewModelScope.launch {
            movieUseCase.invoke()
                .flowOn(dispatcher)
                .onStart { handleLoading() }
                .catch{ handleError()}
                .collect(::handleMoviesSuccess)
        }
    }


    private fun handleMoviesSuccess(movieResults: List<Movie>) {
        if (movieResults.isNotEmpty()) {
            Log.d("<L>", "MovieError:${movieResults} ")
            _viewState.value = MovieStateView( isLoading = false,
                 getMoviesResultItems = movieResults , moviesFailure = false)
        } else {
            handleError()
        }
    }

    private fun handleError() {
            _viewState.value = MovieStateView(isLoading = false,
                getMoviesResultItems = null, moviesFailure = true)
        }

    private fun handleLoading() {
        MovieStateView(isLoading = true, getMoviesResultItems = null, moviesFailure = false)
    }
}
