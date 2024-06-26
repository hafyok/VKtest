package com.partitionsoft.vktest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.partitionsoft.vktest.data.ProductData

@Composable
fun ProductItemScreen(onDismissRequest: () -> Unit, product: ProductData, modifier: Modifier) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                //.fillMaxSize()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                //modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(product.thumbnail?.replace("http:", "https:"))
                        .crossfade(true)
                        .build(),
                    error = painterResource(id = R.drawable.vk_logo),
                    placeholder = painterResource(id = R.drawable.loading_img),
                    contentDescription = stringResource(id = R.string.content_description),
                    contentScale = ContentScale.Crop,
                )
                product.title?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Start,
                        modifier = modifier
                            .padding(4.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }

                product.description?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Start,
                        modifier = modifier
                            .padding(4.dp),
                        //fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}