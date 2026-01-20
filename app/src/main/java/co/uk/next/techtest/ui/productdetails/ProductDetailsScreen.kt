package co.uk.next.techtest.ui.productdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.ui.productdetails.compontents.CustomTopAppBar
import co.uk.next.techtest.ui.productdetails.compontents.ProductDescriptionSection
import co.uk.next.techtest.ui.productdetails.compontents.ProductHeaderSection
import co.uk.next.techtest.ui.productdetails.compontents.ProductImagePager
import co.uk.next.techtest.ui.productdetails.compontents.StickyAddToBagBottomBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProductDetailsRoute(
    productId: Int,
    onBackPress: () -> Unit,
    viewModel: ProductDetailsViewModel = koinViewModel(),

    ) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(productId) {
        viewModel.onStart(productId)
    }

    when (val state = uiState) {
        is ProductDetailsUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ProductDetailsUiState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.message)
            }
        }

        is ProductDetailsUiState.Success -> {
            ProductDetailsScreen(product = state.product, onBackPress = onBackPress)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    product: Product,
    onBackPress: () -> Unit
) {
    Scaffold(
        topBar = { CustomTopAppBar(title = product.title, onBackPress = onBackPress)},
        bottomBar = { StickyAddToBagBottomBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            ProductImagePager(images = product.images)

            ProductHeaderSection(product = product)

            ProductDescriptionSection(description = product.description)

            Spacer(Modifier.height(24.dp))
        }
    }
}
