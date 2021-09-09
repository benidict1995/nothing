package com.metromart.data.features.payment

import com.metromart.network.features.payment.PaymentRemoteSource
import javax.inject.Inject

class PaymentRepositoryImpl @Inject constructor(
    private val paymentRemoteSource: PaymentRemoteSource
): PaymentRepository {

}