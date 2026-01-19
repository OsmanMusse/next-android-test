package co.uk.next.techtest.ui.products.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProductTitle(title: String){
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 2,
        minLines = 2
    )
}