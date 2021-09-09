package com.metromart.network.module

import com.metromart.network.features.auth.AuthRemoteSource
import com.metromart.network.features.auth.AuthRemoteSourceImpl
import com.metromart.network.features.auth.AuthService
import com.metromart.network.features.payment.PaymentRemoteSource
import com.metromart.network.features.payment.PaymentRemoteSourceImpl
import com.metromart.network.features.payment.PaymentService
import com.metromart.network.features.products.ProductRemoteSource
import com.metromart.network.features.products.ProductRemoteSourceImpl
import com.metromart.network.features.products.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteSourceModule {

    @Provides
    @Singleton
    fun provideAuthRemoteSource(authService: AuthService): AuthRemoteSource = AuthRemoteSourceImpl(authService)

    @Provides
    @Singleton
    fun providePaymentRemoteSource(paymentService: PaymentService): PaymentRemoteSource = PaymentRemoteSourceImpl(paymentService)

    @Provides
    @Singleton
    fun provideProductsRemoteSource(productService: ProductService): ProductRemoteSource = ProductRemoteSourceImpl(productService)

}