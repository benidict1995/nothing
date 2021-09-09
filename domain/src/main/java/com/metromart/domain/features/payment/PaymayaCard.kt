package com.metromart.domain.features.payment

data class PaymayaCard (
    val id: String,
    val cardNumber: String,
    val cvv: String,
    val expiryDate: String
)