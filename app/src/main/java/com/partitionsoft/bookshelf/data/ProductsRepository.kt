package com.partitionsoft.bookshelf.data

import com.partitionsoft.bookshelf.network.ProductRetrofit

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
        ProductData(
            title = items.title,
            description = items.description,
            thumbnail = items.thumbnail
        )
    }
}