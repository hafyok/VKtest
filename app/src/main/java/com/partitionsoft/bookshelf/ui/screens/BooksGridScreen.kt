package com.partitionsoft.bookshelf.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.partitionsoft.bookshelf.data.ProductData

@Composable
fun BooksGridScreen(
    products: List<ProductData>,
    modifier: Modifier,
    //onProductClicked: (ProductData) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        itemsIndexed(products) { _, prod ->
            BooksCard(product = prod, modifier, /*onProductClicked*/)
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
            product.title?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 8.dp)
                )
            }
            AsyncImage(
                modifier = modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(product.thumbnail?.replace("http:", "https:"))
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_book_96),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Crop
            )
        }
    }
}