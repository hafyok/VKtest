package com.partitionsoft.bookshelf.data

import com.partitionsoft.bookshelf.network.ProductRetrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NewAppContainer {
}

class DefaultNewAppContainer : NewAppContainer{
    private val BASE_URL = "https://dummyjson.com/products"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ProductRetrofit by lazy {
        retrofit.create(ProductRetrofit::class.java)
    }
}