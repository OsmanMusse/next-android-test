package co.uk.next.techtest.ui.productdetails.compontents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductImagePager(
    images: List<String>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        ) { page ->
            val url = images.getOrNull(page)
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(images.size) { index ->
                val selected = index == pagerState.currentPage
                Box(
                    modifier = Modifier
                        .size(if (selected) 7.dp else 6.dp)
                        .clip(CircleShape)
                        .background(if (selected) Color.DarkGray else Color.LightGray)
                )
            }
        }
    }
}