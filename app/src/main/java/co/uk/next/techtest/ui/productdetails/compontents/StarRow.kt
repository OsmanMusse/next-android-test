package co.uk.next.techtest.ui.productdetails.compontents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StarsRow(
    rating: Double,
    modifier: Modifier = Modifier
) {
    val fullStars = rating.toInt().coerceIn(0, 5)
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        repeat(5) { index ->
            val filled = index < fullStars
            Icon(
                imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.StarBorder,
                contentDescription = null,
                tint = if (filled) Color(0xFFFFB300) else Color.Gray
            )
        }
    }
}