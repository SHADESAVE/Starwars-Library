package com.example.starwarslib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }
    private fun setupNavigation() {
        val navController = findNavController(navigation_host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
        findNavController(navigation_host_fragment).navigateUp()
}
