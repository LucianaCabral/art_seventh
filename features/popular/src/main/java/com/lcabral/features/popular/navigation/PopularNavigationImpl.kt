package com.lcabral.features.popular.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.PopularNavigation
import com.lcabral.features.popular.presentation.PopularFragment

internal class PopularNavigationImpl : PopularNavigation {
    override fun navigateToPopular(): Fragment = PopularFragment.newInstance()
}
