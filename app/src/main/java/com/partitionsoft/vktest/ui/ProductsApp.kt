package com.partitionsoft.vktest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.partitionsoft.vktest.ui.screens.HomeScreen

@Composable
fun ProductsApp(
    modifier: Modifier = Modifier,
    //onProductsClicked: (ProductData) -> Unit
) {
    val productsViewModel: ProductsViewModel =
        viewModel(factory = ProductsViewModel.Factory)
    /*val searchWidgetState = booksViewModel.searchWidgetState
    val searchTextState = booksViewModel.searchTextState*/

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { /*TopAppBar(title = { Text(stringResource(id = R.string.app_name))})*/
            /*MainAppBar(
                searchWidgetState = searchWidgetState.value,
                searchTextState = searchTextState.value,
                onTextChange = {
                    booksViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    booksViewModel.updateSearchWidgetState(newValue = BooksViewModel.SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    booksViewModel.getBooks(it)
                },
                onSearchTriggered = {
                    booksViewModel.updateSearchWidgetState(newValue = BooksViewModel.SearchWidgetState.OPENED)
                }
            )*/
        }
    ) {
        Surface(modifier = modifier
            .fillMaxSize()
            .padding(it),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                productsUiState = productsViewModel.productsUiState,
                retryAction = { productsViewModel.getProducts() },
                modifier = modifier,
                productsViewModel = productsViewModel
                //onProductsClicked
            )
        }
    }
}