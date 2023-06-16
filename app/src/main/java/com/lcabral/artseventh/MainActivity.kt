package com.lcabral.artseventh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.lcabral.artseventh.databinding.ActivityMainBinding
import com.lcabral.core.common.navigation.TrendsNavigation
import com.lcabral.trends.presentation.TrendingFragment
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val trendingNavigation: TrendsNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

            supportFragmentManager.commit {
                replace(R.id.container_main, trendingNavigation.navigateToTrend(), "TAG")
            }
    }
}

