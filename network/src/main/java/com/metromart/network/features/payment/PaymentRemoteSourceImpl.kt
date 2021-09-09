package com.metromart.network.features.payment

import javax.inject.Inject

class PaymentRemoteSourceImpl @Inject constructor(
    private val paymentService: PaymentService
): PaymentRemoteSource {
}