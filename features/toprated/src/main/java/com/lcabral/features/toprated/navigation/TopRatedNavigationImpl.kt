package com.lcabral.features.toprated.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.TopRatedNavigation
import com.lcabral.features.toprated.presentation.TopRatedFragment

internal class TopRatedNavigationImpl: TopRatedNavigation {
    override fun create(): Fragment = TopRatedFragment.newInstance()

}
