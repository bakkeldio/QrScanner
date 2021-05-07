package com.example.qrscanner.presentation.activity

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController


import androidx.navigation.ui.setupActionBarWithNavController
import com.example.qrscanner.R
import com.example.qrscanner.data.AppPreferences
import com.example.qrscanner.databinding.ActivityMainBinding
import com.example.qrscanner.extension.setupWithNavController
import com.example.qrscanner.util.ContextUtils
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private var currentNavController: LiveData<NavController>? = null


    private lateinit var binding : ActivityMainBinding

    override fun attachBaseContext(newBase: Context) {
        val localeToSwitchTo = Locale(AppPreferences.language)
        val localeUpdatedContext: ContextWrapper = ContextUtils.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navGraphIds = listOf(
            R.navigation.qr_scanner,
            R.navigation.list_of_qr,
            R.navigation.qr_detail
        )

        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment_container,
            intent = intent
        )

        controller.observe(this, { navController ->
            setupActionBarWithNavController(navController)
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}