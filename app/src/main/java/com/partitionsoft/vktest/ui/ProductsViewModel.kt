package com.partitionsoft.vktest.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.partitionsoft.vktest.ProductsApplication
import com.partitionsoft.vktest.data.ProductData
import com.partitionsoft.vktest.data.ProductsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ProductsUiState {
    data class Success(val productsSearch: List<ProductData>) : ProductsUiState
    object Error : ProductsUiState
    object Loading : ProductsUiState
}

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    var productsUiState: ProductsUiState by mutableStateOf(ProductsUiState.Loading)
        private set
    private var skip = 0

    init {
        getProducts()
    }

    fun getProducts(limitResults: Int = 20) {
        viewModelScope.launch {
            productsUiState = ProductsUiState.Loading
            productsUiState =
                try {
                    ProductsUiState.Success(productsRepository.getProducts(limitResults, skip))
                } catch (e: IOException) {
                    ProductsUiState.Error
                } catch (e: HttpException) {
                    ProductsUiState.Error
                }
        }
    }

    fun nextPage(){
        if (skip < 80) skip += 20
    }

    fun previousPage(){
        if (skip > 0) skip -= 20
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ProductsApplication)
                Log.d("Application key value", "Application key is $application")
                val productsRepository = application.container.productsRepository
                ProductsViewModel(productsRepository = productsRepository)
            }
        }
    }
}