package com.partitionsoft.bookshelf.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.partitionsoft.bookshelf.ui.ProductsUiState

@Composable
fun HomeScreen(
    productsUiState: ProductsUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
    //onProductClicked: (ProductData) -> Unit
) {
    when (productsUiState) {
        is ProductsUiState.Loading -> LoadingScreen(modifier)
        is ProductsUiState.Success -> BooksGridScreen(
            products = productsUiState.productsSearch,
            modifier = modifier,
            //onProductClicked
        )
        is ProductsUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}