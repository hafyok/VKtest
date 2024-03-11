package com.partitionsoft.bookshelf.network.model.newModels

import com.google.gson.annotations.SerializedName


data class VK(

  @SerializedName("products") var products: ArrayList<Product> = arrayListOf(),
  @SerializedName("total") var total: Int? = null,
  @SerializedName("skip") var skip: Int? = null,
  @SerializedName("limit") var limit: Int? = null

)