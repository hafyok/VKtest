package com.partitionsoft.vktest

import android.app.Application
import com.partitionsoft.vktest.data.DefaultNewAppContainer
import com.partitionsoft.vktest.data.NewAppContainer

class ProductsApplication : Application() {
    lateinit var container: NewAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultNewAppContainer()
    }
}