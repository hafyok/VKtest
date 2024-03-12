package com.partitionsoft.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.partitionsoft.bookshelf.ui.ProductsApp
import com.partitionsoft.bookshelf.ui.theme.BookShelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookShelfTheme {
                /*BooksApp(
                    onBookClicked = {
                        ContextCompat.startActivity(
                            this,
                            Intent(Intent.ACTION_VIEW, Uri.parse(it.previewLink)),
                            null
                        )
                    }
                )*/
                ProductsApp()
            }
        }
    }
}