package com.lcabral.features.popular.presentation.viewmodel

import com.lcabral.features.popular.domain.model.Popular

internal data class PopularViewState(
    val isLoading: Boolean = false,
    val popularFailure: Boolean = false,
    val getPopularResultItems: List<Popular>? = null
)
