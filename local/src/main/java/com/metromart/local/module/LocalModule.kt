package com.metromart.local.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.metromart.local.sharedpref.SharedPrefService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun provideNothingSharedPreference(application: Application): SharedPreferences
            = application.getSharedPreferences("nothing", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSharedPrefLocalService(sharedPreferences: SharedPreferences) = SharedPrefService(sharedPreferences)
}