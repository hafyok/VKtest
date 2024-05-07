package com.partitionsoft.vktest.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.partitionsoft.vktest.ui.ProductsUiState
import com.partitionsoft.vktest.ui.ProductsViewModel

@Composable
fun HomeScreen(
    productsUiState: ProductsUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
    productsViewModel: ProductsViewModel
    //onProductClicked: (ProductData) -> Unit
) {
    when (productsUiState) {
        is ProductsUiState.Loading -> LoadingScreen(modifier)
        is ProductsUiState.Success -> ProductGridScreen(
            products = productsUiState.productsSearch,
            modifier = modifier,
            productsViewModel
            //onProductClicked
        )
        is ProductsUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}