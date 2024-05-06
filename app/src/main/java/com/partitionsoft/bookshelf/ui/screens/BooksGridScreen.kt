package com.partitionsoft.bookshelf.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.partitionsoft.bookshelf.data.ProductData
import com.partitionsoft.bookshelf.ui.ProductsViewModel


@Preview
@Composable
fun PreviewBooksGridScreen() {
    val productsViewModel: ProductsViewModel =
        viewModel(factory = ProductsViewModel.Factory)
    val product = listOf<ProductData>(
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test ",
            "Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),

        )
    BooksGridScreen(products = product, modifier = Modifier, productsViewModel = productsViewModel)
}

@Composable
fun BooksGridScreen(
    products: List<ProductData>,
    modifier: Modifier,
    productsViewModel: ProductsViewModel
    //onProductClicked: (ProductData) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            itemsIndexed(products) { _, prod ->
                BooksCard(product = prod, modifier /*onProductClicked*/)
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Button(onClick = { }) {
                Text(text = "Previous")
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Button(onClick = {
                productsViewModel.nextPage()
                productsViewModel.getProducts()
            }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun BooksCard(
    product: ProductData,
    modifier: Modifier,
    //onBookClicked: (ProductData) -> Unit
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(296.dp),
        //.clickable { onBookClicked(product) },
        elevation = 8.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                modifier = modifier.size(230.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(product.thumbnail?.replace("http:", "https:"))
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_book_96),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Crop
            )
            product.title?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 4.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            product.description?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 4.dp),
                    //fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

