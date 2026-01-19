package co.uk.next.techtest.ui.products.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

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