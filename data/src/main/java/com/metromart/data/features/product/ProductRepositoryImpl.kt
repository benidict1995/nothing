package com.metromart.data.features.product

import com.metromart.network.features.products.ProductRemoteSource
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productRemoteSource: ProductRemoteSource
): ProductRepository {
}