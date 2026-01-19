package co.uk.next.techtest.ui.products.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ProductBrandTitle(title: String){
    Text(
        text = title,
        color = Color.Gray,
        style = MaterialTheme.typography.bodyMedium
    )
}