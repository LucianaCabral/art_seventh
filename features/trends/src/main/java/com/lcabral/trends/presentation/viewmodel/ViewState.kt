package com.lcabral.trends.presentation.viewmodel

import com.lcabral.trends.domain.model.Trending

/**TrendingState corresponde a tudo que pode ser mostrado na tela, cada estado de cada view.
 * esta classe será usada para renderizar os dados da tela.**/

internal data class ViewState(
    val isLoading: Boolean = false,
    val isErrorVisible: Boolean = false,
    val getTrendingsResultItems: List<Trending>
)
