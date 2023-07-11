package com.lcabral.features.movies.navigation

import androidx.fragment.app.Fragment
import com.lcabral.core.common.navigation.MovieNavigation
import com.lcabral.features.movies.presentation.MovieFragment

internal class MovieNavigationImpl : MovieNavigation{
    override fun create(): Fragment = MovieFragment.newInstance()
}
