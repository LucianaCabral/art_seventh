package com.lcabral.artseventh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.lcabral.artseventh.databinding.ActivityMainBinding
import com.lcabral.core.common.navigation.TrendsNavigation
import org.koin.android.ext.android.inject

private const val TAG = "Main Activity"
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val trendingNavigation: TrendsNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container_main, trendingNavigation.navigateToTrend(), "TAG")
            }
        }
    }
}

