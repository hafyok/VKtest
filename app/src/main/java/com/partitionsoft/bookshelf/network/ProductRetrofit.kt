package com.partitionsoft.bookshelf.network

import com.partitionsoft.bookshelf.network.model.newModels.VK
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductRetrofit {
    @GET("products")
    suspend fun vkProdSearch(
        @Query("limits") limitResults: Int,
        @Query("skip") skipResults: Int
    ): VK
}