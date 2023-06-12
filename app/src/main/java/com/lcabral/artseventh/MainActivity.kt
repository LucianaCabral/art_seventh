package com.lcabral.artseventh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.lcabral.artseventh.databinding.ActivityMainBinding
import com.lcabral.trends.presentation.TrendingFragment


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_main, TrendingFragment())
                .commit()
        }
        showTrendingFragmentFlow()
    }

    private fun showTrendingFragmentFlow() {
        val transaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, TrendingFragment())
        transaction.commit()
    }
}
