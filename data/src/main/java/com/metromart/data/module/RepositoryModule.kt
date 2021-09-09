package com.metromart.data.module

import com.metromart.data.features.auth.AuthRepository
import com.metromart.data.features.auth.AuthRepositoryImpl
import com.metromart.data.features.payment.PaymentRepository
import com.metromart.data.features.payment.PaymentRepositoryImpl
import com.metromart.data.features.product.ProductRepository
import com.metromart.data.features.product.ProductRepositoryImpl
import com.metromart.local.features.auth.AuthLocalSource
import com.metromart.network.features.auth.AuthRemoteSource
import com.metromart.network.features.payment.PaymentRemoteSource
import com.metromart.network.features.products.ProductRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(
        authRemoteSource: AuthRemoteSource,
        authLocalSource: AuthLocalSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteSource, authLocalSource)

    @Provides
    @Singleton
    fun providePaymentRepository(paymentRemoteSource: PaymentRemoteSource): PaymentRepository = PaymentRepositoryImpl(paymentRemoteSource)

    @Provides
    @Singleton
    fun provideProductRepository(productRemoteSource: ProductRemoteSource): ProductRepository = ProductRepositoryImpl(productRemoteSource)
}