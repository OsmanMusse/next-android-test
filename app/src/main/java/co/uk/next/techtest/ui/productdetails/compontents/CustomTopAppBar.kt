package co.uk.next.techtest.ui.productdetails.compontents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun CustomTopAppBar(
    title: String,
    onBackPress: () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Share, contentDescription = "Share")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favourite")
            }
        }
    )
}