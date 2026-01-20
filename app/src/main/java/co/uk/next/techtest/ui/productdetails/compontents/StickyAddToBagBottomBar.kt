package co.uk.next.techtest.ui.productdetails.compontents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StickyAddToBagBottomBar() {
    Surface(shadowElevation = 6.dp) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("ADD TO BAG")
            }
        }
    }
}
