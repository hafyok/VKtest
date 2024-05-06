package com.partitionsoft.bookshelf.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.partitionsoft.bookshelf.ProductsApplication
import com.partitionsoft.bookshelf.data.ProductData
import com.partitionsoft.bookshelf.data.ProductsRepository
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

    init {
        getProducts()
    }

    fun getProducts(limitResults: Int = 20, skipResults: Int = 0) {
        viewModelScope.launch {
            productsUiState = ProductsUiState.Loading
            productsUiState =
                try {
                    ProductsUiState.Success(productsRepository.getProducts(limitResults, skipResults))
                } catch (e: IOException) {
                    ProductsUiState.Error
                } catch (e: HttpException) {
                    ProductsUiState.Error
                }
        }
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