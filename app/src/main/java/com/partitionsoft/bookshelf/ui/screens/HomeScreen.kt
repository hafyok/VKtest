package com.partitionsoft.bookshelf.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.partitionsoft.bookshelf.ui.ProductsUiState
import com.partitionsoft.bookshelf.ui.ProductsViewModel

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
        is ProductsUiState.Success -> BooksGridScreen(
            products = productsUiState.productsSearch,
            modifier = modifier,
            productsViewModel
            //onProductClicked
        )
        is ProductsUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}