package com.metromart.network.features.products

import javax.inject.Inject

class ProductRemoteSourceImpl @Inject constructor(
    private val productService: ProductService
): ProductRemoteSource{
}