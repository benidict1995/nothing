package com.metromart.local.module

import com.metromart.local.features.auth.AuthLocalService
import com.metromart.local.sharedpref.SharedPrefService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalServiceModule {
    @Singleton
    @Provides
    fun provideAuthLocalService(
        sharedPrefService: SharedPrefService
    ) = AuthLocalService(sharedPrefService)
}