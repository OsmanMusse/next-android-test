package co.uk.next.techtest.ui.products

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.uk.next.techtest.data.Product
import coil.compose.AsyncImage

@Composable
fun ProductsScreen(viewModel: ProductsViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            columns = GridCells.Fixed(2)
        ) {
            itemsIndexed(products) { index, product ->
                ProductCard(product)
            }
        }
    }
}


@Composable
fun ProductThumbnail(imageUrl: String){
    AsyncImage(
        model = imageUrl,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .border(2.dp, Color.Red),
        contentDescription = null
    )
}

@Composable
fun ProductTitle(title: String){
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 2,
        minLines = 2
    )
}

@Composable
fun ProductBrandTitle(title: String){
    Text(
        text = title,
        color = Color.Gray,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun ProductPriceRow(
    price: Double,
    discountedPrice: Double
){
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "£$price",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "£$discountedPrice",
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            textDecoration = TextDecoration.LineThrough,
        )
    }
}

@Composable
fun ProductContentView(product: Product){
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        ProductTitle(title = product.title)
        product.brand?.let { brand ->
            ProductBrandTitle(title = brand)
        }
        ProductPriceRow(price = product.price, discountedPrice = product.discountPercentage)
    }
}

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier.border(2.dp, Color.Red)
    ) {
        ProductThumbnail(product.thumbnail)
        ProductContentView(product)
    }
}
