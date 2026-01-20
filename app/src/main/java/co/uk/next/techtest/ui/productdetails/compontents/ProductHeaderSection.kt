package co.uk.next.techtest.ui.productdetails.compontents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.ui.productdetails.StarsRow

@Composable
fun ProductHeaderSection(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "£${formatPrice(product.price)}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )

            val wasPrice = calculateWasPrice(product.price, product.discountPercentage)
            if (wasPrice != null) {
                Text(
                    text = "£${formatPrice(wasPrice)}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
            }

            if (product.discountPercentage > 0) {
                SaleBadge()
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StarsRow(rating = product.rating)
            Text(
                text = formatRating(product.rating),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        Text(
            text = product.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "SKU: ${product.id}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
private fun SaleBadge() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFD32F2F))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = "SALE",
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

private fun formatRating(rating: Double): String = String.format("%.1f", rating)
private fun formatPrice(price: Double): String = String.format("%.2f", price)

private fun calculateWasPrice(price: Double, discountPercentage: Double): Double? {
    if (discountPercentage <= 0) return null
    val factor = 1.0 - (discountPercentage / 100.0)
    if (factor <= 0) return null
    return price / factor
}
