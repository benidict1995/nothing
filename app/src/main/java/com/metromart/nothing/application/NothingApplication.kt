package com.metromart.nothing.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NothingApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}