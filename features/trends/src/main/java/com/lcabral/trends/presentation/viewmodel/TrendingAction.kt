package com.lcabral.trends.presentation.viewmodel

/** É um conjunto de interações que o usuário pode realizar na tela.**/

internal sealed class TrendingAction {
    object NavigateToHome : TrendingAction()
}
