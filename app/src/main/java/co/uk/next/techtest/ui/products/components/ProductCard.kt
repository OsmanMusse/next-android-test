package co.uk.next.techtest.ui.products.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.uk.next.techtest.domain.model.Product


@Composable
fun ProductCard(product: Product, onProductClick: () -> Unit) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 1.25.dp,Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        onClick = onProductClick
    ) {
        ProductThumbnail(product.thumbnail)
        ProductContentView(product)
    }
}