package com.partitionsoft.vktest.data

import android.util.Log
import com.partitionsoft.vktest.network.ProductRetrofit

interface ProductsRepository{
    suspend fun getProducts(limitResults: Int, maxResults: Int) : List<ProductData>

}

class NetworkProductsRepository(
    private val productRetrofit: ProductRetrofit
): ProductsRepository{
    override suspend fun getProducts(
        limitResults: Int,
        maxResults: Int
    ): List<ProductData> = productRetrofit.vkProdSearch(limitResults, maxResults).productDTOS.map {items ->
        Log.d("PRODUCTS", "GET")
        ProductData(
            title = items.title,
            description = items.description,
            thumbnail = items.thumbnail
        )
    }
}