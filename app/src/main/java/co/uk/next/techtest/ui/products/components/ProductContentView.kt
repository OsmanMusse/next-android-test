package co.uk.next.techtest.ui.products.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.uk.next.techtest.domain.model.Product


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