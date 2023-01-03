package com.boreal.allen.ui

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.boreal.allen.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun MainActivity.initElements() {
    binding.apply {
        lifecycleScope.launch(Dispatchers.Main) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.navigation_base) as NavHostFragment
            navController = navHostFragment.navController
        }
    }
}