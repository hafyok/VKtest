package com.partitionsoft.vktest.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.partitionsoft.vktest.data.ProductData
import com.partitionsoft.vktest.ui.ProductsViewModel


@Preview
@Composable
fun PreviewProductGridScreen() {
    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)
    val product = listOf(
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),
        ProductData(
            "Title Test Title Test Title Test",
            "Description test Description test Description test",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
        ),

        )
    ProductGridScreen(
        products = product, modifier = Modifier, productsViewModel = productsViewModel
    )
}

@Composable
fun ProductGridScreen(
    products: List<ProductData>, modifier: Modifier, productsViewModel: ProductsViewModel
    //onProductClicked: (ProductData) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp), contentPadding = PaddingValues(4.dp)
        ) {
            itemsIndexed(products) { _, prod ->
                ProductCard(product = prod, modifier /*onProductClicked*/)
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Button(onClick = {
                productsViewModel.previousPage()
                productsViewModel.getProducts()
            }) {
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
fun ProductCard(
    product: ProductData,
    modifier: Modifier,
    //onBookClicked: (ProductData) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .clickable { showDialog = true }
            .shadow(elevation = 15.dp)
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(296.dp),
        elevation = 8.dp) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                modifier = modifier.size(230.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(product.thumbnail?.replace("http:", "https:")).crossfade(true).build(),
                error = painterResource(id = R.drawable.vk_logo),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Crop
            )
            product.title?.let {
                AnimatedTextReading(text = it)
            }

            product.description?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Start,
                    modifier = modifier.padding(4.dp),
                    fontSize = 14.sp
                )
            }
        }
    }

    if (showDialog) {
        ProductItemScreen(onDismissRequest = { showDialog = false }, product, Modifier)
    }
}


@Composable
fun AnimatedTextReading(text: String) {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = -250f, animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing), repeatMode = RepeatMode.Restart
        )
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Box(
                modifier = Modifier.offset(x = offsetX.dp)
            ) {
                Text(
                    text = text, modifier = Modifier.padding(2.dp), style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Start
                    )
                )
            }
        }
    }
}
