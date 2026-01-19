package co.uk.next.techtest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.uk.next.techtest.ui.products.ProductsScreen
import kotlinx.serialization.Serializable


@Serializable
object ProductScreen

@Composable
fun NextNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ProductScreen) {
        composable<ProductScreen> {
            ProductsScreen()
        }
    }
}