package com.lcabral.artseventh

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.lcabral.artseventh.databinding.ActivityMainBinding
import com.lcabral.core.common.navigation.DashboardNavigation
import com.lcabral.core.common.navigation.SearchNavigation
import org.koin.android.ext.android.inject

private const val MAIN_ACTIVITY = "Main Activity"

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val dashboardNavigation: DashboardNavigation by inject()
    private val searchNavigation: SearchNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.BLACK

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container_main, dashboardNavigation.create())
            }
        }
        setupBottomNavigation()
    }


    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.dashboardFragment -> goToDashboard()
                R.id.searchFragment -> goToSearch()
                R.id.favoriteFragment -> goToFavorite()
                else -> {}
            }
            true
        }
    }

    private fun goToDashboard() {
        supportFragmentManager.commit {
            replace(R.id.container_main, dashboardNavigation.create())
        }
    }

    private fun goToSearch() {
        supportFragmentManager.commit {
            replace(R.id.container_main, searchNavigation.create())
        }
    }

    private fun goToFavorite() {
        supportFragmentManager.commit {
            replace(R.id.container_main, dashboardNavigation.create(), MAIN_ACTIVITY)
        }
    }
}

