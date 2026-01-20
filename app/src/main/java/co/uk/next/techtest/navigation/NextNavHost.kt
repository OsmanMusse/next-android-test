package co.uk.next.techtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import co.uk.next.techtest.ui.productdetails.ProductDetailsRoute
import co.uk.next.techtest.ui.products.ProductsScreen
import kotlinx.serialization.Serializable


@Serializable
object ProductScreen

@Serializable
data class ProductDetailsScreen(val id: Int)

@Composable
fun NextNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ProductScreen) {
        composable<ProductScreen> {
            ProductsScreen(
                onProductClick = { productId ->
                    navController.navigate(ProductDetailsScreen(productId))
                }
            )
        }
        composable<ProductDetailsScreen> { backStackEntry ->
            val product: ProductDetailsScreen = backStackEntry.toRoute()
            ProductDetailsRoute(
                productId = product.id,
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}