package com.partitionsoft.vktest.network

import com.partitionsoft.vktest.network.model.newModels.VK
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductRetrofit {
    @GET("products")
    suspend fun vkProdSearch(
        @Query("limit") limitResults: Int,
        @Query("skip") skipResults: Int
    ): VK
}