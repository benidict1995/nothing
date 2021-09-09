package com.metromart.local.module

import com.metromart.local.features.auth.AuthLocalService
import com.metromart.local.features.auth.AuthLocalSource
import com.metromart.local.features.auth.AuthLocalSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModule {

    @Provides
    @Singleton
    fun provideAuthLocalSource(
        authLocalService: AuthLocalService
        //, room: RoomDB
    ): AuthLocalSource = AuthLocalSourceImpl(authLocalService)


}