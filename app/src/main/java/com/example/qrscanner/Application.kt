package com.example.qrscanner

import android.app.Application
import android.content.Context
import com.example.qrscanner.data.AppPreferences
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class Application : Application(){


    override fun attachBaseContext(base: Context) {
        AppPreferences.init(base)
        super.attachBaseContext(base)
    }
}