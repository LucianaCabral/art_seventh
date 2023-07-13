package com.lcabral.features.search.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.SearchNavigation
import com.lcabral.features.search.presentation.SearchFragment

internal class SearchNavigationImpl: SearchNavigation {
    override fun create(): Fragment = SearchFragment.newInstance()
}
