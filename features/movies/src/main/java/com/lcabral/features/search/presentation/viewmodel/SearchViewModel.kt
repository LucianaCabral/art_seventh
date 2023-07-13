package com.lcabral.features.search.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcabral.arch.extensions.orFalse
import com.lcabral.features.movies.domain.model.Movie
import com.lcabral.features.search.domain.usecase.SearchMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


private const val MIN_QUERY_SIZE = 3
private const val DEBOUNCE_TIMEOUT = 2L

internal class SearchViewModel(
    private val searchUseCase: SearchMoviesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _viewState: MutableLiveData<SearchViewState> = MutableLiveData<SearchViewState>()
    private val viewState: LiveData<SearchViewState> = _viewState

    private var queryText: String? = null

    private val queryTextChangedPublishSubject = PublishSubject.create<String>()
    private val queryTextSubmittedPublishSubject = PublishSubject.create<String>()


    init {
        setupQueryTextChangedPublishSubject()
        setupQueryTexSubmittedPublishSubject()
    }

//    fun onQueryTextSubmitted(text: CharSequence?) {
//        queryTextSubmittedPublishSubject.onNext(text?.toString().orEmpty())
//    }

    private fun submittedSearch(query: String) {
        queryText = query
        viewModelScope.launch {
            searchUseCase.invoke(query)
                .flowOn(dispatcher)
                .onStart { handleSearchLoading() }
                .catch { handleError() }
                .collect(::handleSuccess)
        }
    }

    private fun handleSearchLoading() {
        SearchViewState(isLoadingVisible = true, isErrorVisible = false, searchResultItems = null)
    }

    private fun handleError() {
        SearchViewState(isLoadingVisible = false, isErrorVisible = true, searchResultItems = null)
    }

    private fun handleSuccess(movies: List<Movie>) {
        SearchViewState(
            isLoadingVisible = false,
            isErrorVisible = false,
            searchResultItems = movies
        )
    }

    private fun setupQueryTexSubmittedPublishSubject() {
        queryTextSubmittedPublishSubject
            .filter { isLoadingVisible()?.not() ?: false }
            .subscribe { queryTextSubmittedPublishSubject.onNext(it) }
            .handleDisposable
    }

    private fun setupQueryTextChangedPublishSubject() {
        queryTextChangedPublishSubject
            .debounce(DEBOUNCE_TIMEOUT, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .filter { it.length >= MIN_QUERY_SIZE }
            .subscribe { queryTextChangedPublishSubject.onNext(it) }
            .handleDisposable
    }

    private val disposable = CompositeDisposable()

     val Disposable.handleDisposable: Disposable
        get() = apply { disposable.add(this) }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun isLoadingVisible(): Boolean? = viewState.value?.isLoadingVisible?.orFalse()
}
