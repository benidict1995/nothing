package com.metromart.network.module

import com.metromart.network.base.BaseService
import com.metromart.network.features.auth.AuthService
import com.metromart.network.features.payment.PaymentService
import com.metromart.network.features.products.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Singleton
    @Provides
    fun provideBaseService(retrofit: Retrofit) = retrofit.create(BaseService::class.java)

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit) = retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun providePaymentService(retrofit: Retrofit) = retrofit.create(PaymentService::class.java)

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit) = retrofit.create(ProductService::class.java)
}