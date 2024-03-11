package com.partitionsoft.bookshelf

import android.app.Application
import com.partitionsoft.bookshelf.data.DefaultNewAppContainer
import com.partitionsoft.bookshelf.data.NewAppContainer

class ProductsApplication : Application() {
    lateinit var container: NewAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultNewAppContainer()
    }
}