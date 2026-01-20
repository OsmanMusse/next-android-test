package co.uk.next.techtest.ui.productdetails

import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.domain.model.repository.ProductsRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class ProductDetailsScreenViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repo: ProductsRepository = mockk()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN repository returns product WHEN onStart is invoked THEN Success state is emitted`() = runTest {
        // GIVEN
        val productId = 1
        val product = Product(
            id = productId,
            title = "iPhone 9",
            description = "desc",
            price = 549.0,
            discountPercentage = 10.0,
            rating = 4.7,
            brand = "Apple",
            thumbnail = "https://cdn.dummyjson.com/product-images/beauty/red-lipstick/thumbnail.webp",
            images = emptyList()
        )

        coEvery { repo.getProduct(productId) } returns product

        val viewModel = ProductDetailsViewModel(repo)

        val states = mutableListOf<ProductDetailsUiState>()
        val job = launch { viewModel.uiState.collect { states.add(it) } }

        // WHEN
        viewModel.onStart(productId)
        advanceUntilIdle()

        // THEN
        assertTrue(states.any { it is ProductDetailsUiState.Loading })
        assertTrue(states.any { it is ProductDetailsUiState.Success && it.product == product })

        job.cancel()
    }
}

