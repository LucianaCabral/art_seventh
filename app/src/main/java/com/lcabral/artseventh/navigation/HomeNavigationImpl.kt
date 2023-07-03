package com.lcabral.artseventh.navigation

import androidx.fragment.app.Fragment
import com.lcabral.artseventh.HomeFragment
import com.lcabral.core.common.navigation.HomeNavigation

class HomeNavigationImpl: HomeNavigation {
    override fun navigateToHome(): Fragment = HomeFragment.newInstance()
}
